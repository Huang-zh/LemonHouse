package LemonHouse.task;

import LemonHouse.LemonScrapy.PageVO.HouseSource;
import LemonHouse.service.HouseDetailService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: huang.zh
 * @Date: 2019/9/19 13:23
 * @Description:爬虫任务
 */
@Component
@Configuration
@EnableScheduling
public class LemonScrapy {
    @Autowired
    private HouseDetailService houseDetailService;
    private static final String prefix = "https://hz.lianjia.com/ershoufang/";
    @Scheduled(cron = "* 02 21 * * ?")
    public void excute() {
        List<JSONObject> list = new ArrayList<>();
        PageParser<HouseSource.SamPleHouse> pageParser = new PageParser<HouseSource.SamPleHouse>() {
            @Override
            public void parse(Document html, Element pageVoElement, HouseSource.SamPleHouse pageVo) {
                // 解析封装 PageVo 对象
                JSONObject object = JSON.parseObject(JSON.toJSONString(pageVo));
                object = getHouseDetail(pageVo.getHouseCode(),object);
                list.add(object);
            }
        };
        int i = 1;
        while (i<=100){
            XxlCrawler crawler  = getCrawler(10,3000,false,pageParser,
                    "https://hz.lianjia.com/ershoufang/pg"+i);
            crawler.start(true);
            i++;
        }
        if (!list.isEmpty())
           houseDetailService.saveSample(list);
    }

    /**
     * @description:获取具体信息
     * @author: huang.zh
     * @return: void
     * @Date: 2019/9/20 9:43
     * @params:[houseCode:房源编码]
     */
    static JSONObject getHouseDetail(String houseCode,JSONObject object){
        String url = prefix+houseCode+".html";
        JSONObject result;
        PageParser<HouseSource.House> pageParser = new PageParser<HouseSource.House>() {
            @Override
            public void parse(Document html, Element pageVoElement, HouseSource.House pageVo) {
                // 解析封装 PageVo 对象
                JSONObject detail = JSON.parseObject(JSON.toJSONString(pageVo));
                object.put("detail",detail);
                getHouseImage(houseCode,object);
            }
        };
        XxlCrawler crawler  = getCrawler(false,pageParser, url);
        crawler.start(true);
        return object;
    }
    /**
     * @description:获取房源图片
     * @author: huang.zh
     * @return: void
     * @Date: 2019/9/20 11:11
     * @params:[houseCode:房源编码]
     */
    static JSONObject getHouseImage(String houseCode,JSONObject object){
        String url = prefix+houseCode+".html";
        PageParser<HouseSource.image> pageParser = new PageParser<HouseSource.image>() {
            @Override
            public void parse(Document html, Element pageVoElement, HouseSource.image pageVo) {
                // 解析封装 PageVo 对象
                String pageUrl = html.baseUri();
                System.out.println(Thread.currentThread().getName()+" "+pageUrl + "：" + pageVo.toString());
                object.getJSONObject("detail").put("imageSrc",pageVo.getImageSrc());
                getHouseAroundMessage(houseCode,object);
            }
        };
        XxlCrawler crawler  = getCrawler(false,pageParser, url);
        crawler.start(true);
        return object;
    }

    /**
     *  @author: huang.zh
     *  @Date: 2019/9/21 0021 17:31
     *  @Description:获取房源所属模块和地铁信息
     */
    static JSONObject getHouseAroundMessage(String houseCode,JSONObject object){
        String url = prefix+houseCode+".html";
        PageParser<HouseSource.around> pageParser = new PageParser<HouseSource.around>() {
            @Override
            public void parse(Document html, Element pageVoElement, HouseSource.around pageVo) {
                // 解析封装 PageVo 对象
                String pageUrl = html.baseUri();
                System.out.println(Thread.currentThread().getName()+" "+pageUrl + "：" + pageVo.toString());
                object.getJSONObject("detail").put("belong",pageVo.getBelong());
                object.getJSONObject("detail").put("subway",pageVo.getSubway());
            }
        };
        XxlCrawler crawler  = getCrawler(false,pageParser, url);
        crawler.start(true);
        return object;
    }

    public static XxlCrawler getCrawler(PageParser parser,String... url){
        return getCrawler(false,parser,url);
    }
    public static XxlCrawler getCrawler(boolean allowSpread,PageParser parser,String... url){
        return getCrawler(1,allowSpread,parser,url);
    }
    public static XxlCrawler getCrawler(int threadCount,boolean allowSpread,PageParser parser,String... url){
        return getCrawler(threadCount,0,allowSpread,parser,url);
    }

    /**
     * @description:初始化爬虫实例
     * @author: huang.zh
     * @return: com.xuxueli.crawler.XxlCrawler
     * @Date: 2019/9/20 10:00
     * @params:[url, threadCount, pauseMillis, allowSpread, parser]
     */
    public static XxlCrawler getCrawler(int threadCount,int pauseMillis,boolean allowSpread,PageParser parser,String... url){
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls(url)
                .setThreadCount(threadCount)//设置并行爬虫线程
                .setPauseMillis(pauseMillis)//设置停顿时间，避免过于频繁被拦截
                .setAllowSpread(allowSpread)//不允许扩散，不然容易被封禁
                .setPageParser(parser)
                .build();
        return crawler;
    }

}

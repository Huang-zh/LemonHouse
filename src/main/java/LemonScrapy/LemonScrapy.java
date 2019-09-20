package LemonScrapy;

import LemonScrapy.PageVO.HouseSource;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @Auther: huang.zh
 * @Date: 2019/9/19 13:23
 * @Description:爬虫
 */

public class LemonScrapy {

    private static final String prefix = "https://hz.lianjia.com/ershoufang/";

    public static void main(String[] args) {
        PageParser<HouseSource.SamPleHouse> pageParser = new PageParser<HouseSource.SamPleHouse>() {
            @Override
            public void parse(Document html, Element pageVoElement, HouseSource.SamPleHouse pageVo) {
                // 解析封装 PageVo 对象
                String pageUrl = html.baseUri();
//                System.out.println(Thread.currentThread().getName()+" "+pageUrl + "：" + pageVo.toString());
                getHouseDetail(pageVo.getHouseCode());
                getHouseImage(pageVo.getHouseCode());
                System.out.println();
            }
        };
        XxlCrawler crawler  = getCrawler(10,3000,false,pageParser,
                "https://hz.lianjia.com/ershoufang/pg1");
        crawler.start(true);
    }

    /**
     * @description:获取具体信息
     * @author: huang.zh
     * @return: void
     * @Date: 2019/9/20 9:43
     * @params:[houseCode:房源编码]
     */
    static void getHouseDetail(String houseCode){
        String url = prefix+houseCode+".html";
        PageParser<HouseSource.House> pageParser = new PageParser<HouseSource.House>() {
            @Override
            public void parse(Document html, Element pageVoElement, HouseSource.House pageVo) {
                // 解析封装 PageVo 对象
                String pageUrl = html.baseUri();
//                System.out.println(Thread.currentThread().getName()+" "+pageUrl + "：" + pageVo.toString());
            }
        };
        XxlCrawler crawler  = getCrawler(false,pageParser, url);
        crawler.start(true);
    }
    /**
     * @description:获取房源图片
     * @author: huang.zh
     * @return: void
     * @Date: 2019/9/20 11:11
     * @params:[houseCode:房源编码]
     */
    static void getHouseImage(String houseCode){
        String url = prefix+houseCode+".html";
        PageParser<HouseSource.image> pageParser = new PageParser<HouseSource.image>() {
            @Override
            public void parse(Document html, Element pageVoElement, HouseSource.image pageVo) {
                // 解析封装 PageVo 对象
                String pageUrl = html.baseUri();
//                System.out.println(Thread.currentThread().getName()+" "+pageUrl + "：" + pageVo.toString());
            }
        };
        XxlCrawler crawler  = getCrawler(false,pageParser, url);
        crawler.start(true);
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

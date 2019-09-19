package LemonScrapy;

import LemonScrapy.PageVO.HouseSource;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @Auther: huang.zh
 * @Date: 2019/9/19 13:23
 * @Description:爬虫测试类
 */

public class LemonScrapy {

    public static void main(String[] args) {
        
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://hz.lianjia.com/ershoufang/pg1")
                .setThreadCount(10)//设置并行爬虫线程
                .setPauseMillis(3000)//设置停顿时间，避免过于频繁被拦截
                .setAllowSpread(false)//不允许扩散，不然容易被封禁
                .setPageParser(new PageParser<HouseSource.House>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, HouseSource.House pageVo) {
                        // 解析封装 PageVo 对象
                        String pageUrl = html.baseUri();
                        System.out.println(Thread.currentThread().getName()+" "+pageUrl + "：" + pageVo.toString());
                    }
                })
                .build();
        crawler.start(true);
    }

}

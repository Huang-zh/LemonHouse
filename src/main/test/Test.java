import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @Auther: huang.zh
 * @Date: 2019/9/19 15:16
 * @Description:
 */
public class Test {


    public static void main(String[] args) {

        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://gitee.com/xuxueli0323/projects?page=1")
                .setWhiteUrlRegexs("https://gitee\\.com/xuxueli0323/projects\\?page=\\d+")
                .setThreadCount(3)
                .setAllowSpread(false)
                .setPageParser(new PageParser<XxlCrawlerTest.PageImageVo>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, XxlCrawlerTest.PageImageVo pageVo) {
                        // 解析封装 PageVo 对象
                        String pageUrl = html.baseUri();
                        System.out.println(pageUrl + "：" + pageVo.toString());
                    }
                })
                .build();

        System.out.println("start");
        crawler.start(true);
        System.out.println("end");
    }
}

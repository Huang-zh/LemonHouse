import com.xuxueli.crawler.annotation.PageFieldSelect;
import com.xuxueli.crawler.annotation.PageSelect;

/**
 * 爬虫示例01：爬取页面数据并封装VO对象
 *
 * @author xuxueli 2017-10-09 19:48:48
 */
public class XxlCrawlerTest {

    @PageSelect(cssQuery = "#search-projects-ulist .project")
    public static class PageVo {

        @PageFieldSelect(cssQuery = ".repository")
        private String repository;

        @PageFieldSelect(cssQuery = ".description")
        private String description;

        public String getRepository() {
            return repository;
        }

        public void setRepository(String repository) {
            this.repository = repository;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "PageVo{" +
                    "repository='" + repository + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}
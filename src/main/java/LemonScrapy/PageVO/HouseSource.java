package LemonScrapy.PageVO;

import com.xuxueli.crawler.annotation.PageFieldSelect;
import com.xuxueli.crawler.annotation.PageSelect;
import com.xuxueli.crawler.conf.XxlCrawlerConf;

/**
 * @Auther: huang.zh
 * @Date: 2019/9/19 13:24
 * @Description:房源信息数据实体对象
 */

public class HouseSource {
    @PageSelect(cssQuery = "#content > div.leftContent > ul > li")
    public static class House{
        @PageFieldSelect(cssQuery = "div.info.clear > div.title")
        String titles;//标题
        @PageFieldSelect(cssQuery = "div.info.clear > div.address > div")
        String info;//信息
        @PageFieldSelect(selectType = XxlCrawlerConf.SelectType.ATTR,
                cssQuery = "div.info.clear > div.title > a",
                selectVal = "data-housecode")
        String houseCode;//房源编码，唯一
        @PageFieldSelect(selectType = XxlCrawlerConf.SelectType.ATTR,
                cssQuery = "a > img.lj-lazy",
                selectVal = "data-original")
        String sampleImageUrl;//房源信息缩略图
        @PageFieldSelect(cssQuery = "div.info.clear > div.priceInfo > div.totalPrice > span")
        Integer price;//房源总价
        @PageFieldSelect(cssQuery = "div.info.clear > div.priceInfo > div.unitPrice")
        String unitPrice;//单价
        @PageFieldSelect(cssQuery = "div.info.clear > div.tag > span.subway")
        String closeSubway;//是否临近地铁，临近地铁该值不为空
        @PageFieldSelect(cssQuery = "div.info.clear > div.tag > span.taxfree")
        String year;//房本满几年
        public String getUnitPrice() {
            return unitPrice;
        }
        public void setUnitPrice(String unitPrice) {
            this.unitPrice = unitPrice;
        }

        public String getCloseSubway() {
            return closeSubway;
        }

        public void setCloseSubway(String closeSubway) {
            this.closeSubway = closeSubway;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public String getSampleImageUrl() {
            return sampleImageUrl;
        }

        public void setSampleImageUrl(String sampleImageUrl) {
            this.sampleImageUrl = sampleImageUrl;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getTitles() {
            return titles;
        }

        public void setTitles(String titles) {
            this.titles = titles;
        }

        public String getHouseCode() {
            return houseCode;
        }

        public void setHouseCode(String houseCode) {
            this.houseCode = houseCode;
        }


        @Override
        public String toString() {
            return "House{" +
                    "titles='" + titles + '\'' +
                    ", info='" + info + '\'' +
                    ", houseCode='" + houseCode + '\'' +
                    ", sampleImageUrl='" + sampleImageUrl + '\'' +
                    ", price=" + price +
                    ", unitPrice='" + unitPrice + '\'' +
                    ", closeSubway='" + closeSubway + '\'' +
                    ", year='" + year + '\'' +
                    '}';
        }
    }

}

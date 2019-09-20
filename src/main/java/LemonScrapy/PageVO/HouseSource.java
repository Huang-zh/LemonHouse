package LemonScrapy.PageVO;

import com.xuxueli.crawler.annotation.PageFieldSelect;
import com.xuxueli.crawler.annotation.PageSelect;
import com.xuxueli.crawler.conf.XxlCrawlerConf;

import java.util.Date;
import java.util.List;

/**
 * @Auther: huang.zh
 * @Date: 2019/9/19 13:24
 * @Description:房源信息数据实体对象
 */

public class HouseSource {
    /**
     * @description:房源简要信息内部类
     * @author: huang.zh
     * @return:
     * @Date: 2019/9/20 9:42
     * @params:
     */
    @PageSelect(cssQuery = "#content > div.leftContent > ul > li")
    public static class SamPleHouse{
        @PageFieldSelect(selectType = XxlCrawlerConf.SelectType.ATTR,
                cssQuery = "div.info.clear > div.title > a",
                selectVal = "data-housecode")
        String houseCode;//房源编码，唯一

        @PageFieldSelect(cssQuery = "div.info.clear > div.title")
        String titles;//标题

        @PageFieldSelect(cssQuery = "div.info.clear > div.priceInfo > div.totalPrice > span")
        Integer price;//房源总价
        @PageFieldSelect(cssQuery = "div.info.clear > div.priceInfo > div.unitPrice")
        String unitPrice;//单价

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public String getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(String unitPrice) {
            this.unitPrice = unitPrice;
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
            return "SamPleHouse{" +
                    "houseCode='" + houseCode + '\'' +
                    ", titles='" + titles + '\'' +
                    ", price=" + price +
                    ", unitPrice='" + unitPrice + '\'' +
                    '}';
        }
    }

    /**
     * @description:具体信息内部类
     * @author: huang.zh
     * @return:
     * @Date: 2019/9/20 9:42
     * @params:
     */
    @PageSelect(cssQuery = "body > div.m-content > div.box-l")
    public static class House{

        @PageFieldSelect(cssQuery = "#introduction > div > div > div.base > div.content > ul > li:nth-child(1)")
        String apartment;//户型
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.base > div.content > ul > li:nth-child(2)")
        String floor;//楼层
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.base > div.content > ul > li:nth-child(3)")
        String area;//面积
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.base > div.content > ul > li:nth-child(4)")
        String construct;//户型结构
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.base > div.content > ul > li:nth-child(5)")
        String internalArea;//套内面积
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.base > div.content > ul > li:nth-child(6)")
        String buildType;//建筑类型
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.base > div.content > ul > li:nth-child(7)")
        String oriented;//朝向
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.base > div.content > ul > li:nth-child(8)")
        String buildingStructure;//建筑结构
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.base > div.content > ul > li:nth-child(9)")
        String decoration;//装修
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.base > div.content > ul > li:nth-child(10)")
        String ladderRatio;//梯户比例
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.base > div.content > ul > li:nth-child(11)")
        String hasElevator;//配备电梯
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.base > div.content > ul > li:nth-child(12)")
        String propertyRights;//产权年限
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.transaction > div.content > ul > li:nth-child(1)")
        String listingTime;//挂牌时间
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.transaction > div.content > ul > li:nth-child(2)")
        String authority;//交易权属
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.transaction > div.content > ul > li:nth-child(3)")
        String lastTransactionTime;//上次交易时间
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.transaction > div.content > ul > li:nth-child(4)")
        String use;//用途
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.transaction > div.content > ul > li:nth-child(5)")
        String houseYears;//房屋年限
        @PageFieldSelect(cssQuery = "#introduction > div > div > div.transaction > div.content > ul > li:nth-child(7)")
        String mortgage;//抵押信息
        public String getFloor() {
            return floor;
        }

        public void setFloor(String floor) {
            this.floor = floor;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getConstruct() {
            return construct;
        }

        public void setConstruct(String construct) {
            this.construct = construct;
        }

        public String getInternalArea() {
            return internalArea;
        }

        public void setInternalArea(String internalArea) {
            this.internalArea = internalArea;
        }

        public String getBuildType() {
            return buildType;
        }

        public void setBuildType(String buildType) {
            this.buildType = buildType;
        }

        public String getOriented() {
            return oriented;
        }

        public void setOriented(String oriented) {
            this.oriented = oriented;
        }

        public String getBuildingStructure() {
            return buildingStructure;
        }

        public void setBuildingStructure(String buildingStructure) {
            this.buildingStructure = buildingStructure;
        }

        public String getDecoration() {
            return decoration;
        }

        public void setDecoration(String decoration) {
            this.decoration = decoration;
        }

        public String getLadderRatio() {
            return ladderRatio;
        }

        public void setLadderRatio(String ladderRatio) {
            this.ladderRatio = ladderRatio;
        }

        public String getHasElevator() {
            return hasElevator;
        }

        public void setHasElevator(String hasElevator) {
            this.hasElevator = hasElevator;
        }

        public String getPropertyRights() {
            return propertyRights;
        }

        public void setPropertyRights(String propertyRights) {
            this.propertyRights = propertyRights;
        }

        public String getListingTime() {
            return listingTime;
        }

        public void setListingTime(String listingTime) {
            this.listingTime = listingTime;
        }

        public String getAuthority() {
            return authority;
        }

        public void setAuthority(String authority) {
            this.authority = authority;
        }

        public String getLastTransactionTime() {
            return lastTransactionTime;
        }

        public void setLastTransactionTime(String lastTransactionTime) {
            this.lastTransactionTime = lastTransactionTime;
        }

        public String getUse() {
            return use;
        }

        public void setUse(String use) {
            this.use = use;
        }

        public String getHouseYears() {
            return houseYears;
        }

        public void setHouseYears(String houseYears) {
            this.houseYears = houseYears;
        }

        public String getMortgage() {
            return mortgage;
        }

        public void setMortgage(String mortgage) {
            this.mortgage = mortgage;
        }

        public String getApartment() {
            return apartment;
        }

        public void setApartment(String apartment) {
            this.apartment = apartment.substring(4);
        }



        @Override
        public String toString() {
            return "House{" +
                    "apartment='" + apartment + '\'' +
                    ", floor='" + floor + '\'' +
                    ", area='" + area + '\'' +
                    ", construct='" + construct + '\'' +
                    ", internalArea='" + internalArea + '\'' +
                    ", buildType='" + buildType + '\'' +
                    ", oriented='" + oriented + '\'' +
                    ", buildingStructure='" + buildingStructure + '\'' +
                    ", decoration='" + decoration + '\'' +
                    ", ladderRatio='" + ladderRatio + '\'' +
                    ", hasElevator='" + hasElevator + '\'' +
                    ", propertyRights='" + propertyRights + '\'' +
                    ", listingTime='" + listingTime + '\'' +
                    ", authority='" + authority + '\'' +
                    ", lastTransactionTime='" + lastTransactionTime + '\'' +
                    ", use='" + use + '\'' +
                    ", houseYears='" + houseYears + '\'' +
                    ", mortgage='" + mortgage + '\'' +
                    '}';
        }
    }
    @PageSelect(cssQuery = "body > div.m-content > div.box-l>div:nth-child(6) > div > div.container > div")
    public static class image{
        @PageFieldSelect(cssQuery = "div>img",
                selectType = XxlCrawlerConf.SelectType.ATTR,
                selectVal = "abs:src")
        List<String> imageSrc;//图片

        public List<String> getImageSrc() {
            return imageSrc;
        }

        public void setImageSrc(List<String> imageSrc) {
            this.imageSrc = imageSrc;
        }

        @Override
        public String toString() {
            return "image{" +
                    "imageSrc='" + imageSrc + '\'' +
                    '}';
        }
    }
}

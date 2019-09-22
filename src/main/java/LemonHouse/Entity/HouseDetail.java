package LemonHouse.Entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *  @author: huang.zh
 *  @Date: 2019/9/22 0022 11:43
 *  @Description:二手房信息实体类
 */
@Data
@TableName("houseDetail")
public class HouseDetail {

    private Integer id;
    @TableField("houseCode")
    private String houseCode;//房源编码，唯一
    @TableField("title")
    private String titles;//标题
    private Integer price;//房源总价
    @TableField("unitPrice")
    private String unitPrice;//单价
    private String apartment;//户型
    private String floor;//楼层
    private String area;//面积
    private String construct;//户型结构
    @TableField("internalArea")
    private String internalArea;//套内面积
    @TableField("buildType")
    private String buildType;//建筑类型
    private String oriented;//朝向
    @TableField("buildingStructure")
    private String buildingStructure;//建筑结构
    private String decoration;//装修
    @TableField("ladderRatio")
    private String ladderRatio;//梯户比例
    @TableField("hasElevator")
    private String hasElevator;//配备电梯
    @TableField("propertyRights")
    private String propertyRights;//产权年限
    @TableField("listingTime")
    private String listingTime;//挂牌时间
    private String authority;//交易权属
    @TableField("lastTransactionTime")
    private String lastTransactionTime;//上次交易时间
    @TableField("mainUse")
    private String mainUse;//用途
    @TableField("houseYears")
    private String houseYears;//房屋年限
    private String mortgage;//抵押信息
    @TableField("imageSrc")
    private String imageSrc;//图片url
    private String belong;//所属区和街道
    private String subway;//地铁信息
}

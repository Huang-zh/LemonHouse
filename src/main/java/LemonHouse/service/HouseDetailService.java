package LemonHouse.service;


import LemonHouse.Entity.HouseDetail;
import LemonHouse.dao.HouseDetailDao;
import LemonHouse.utils.LemonUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author: huang.zh
 *  @Date: 2019/9/21 0021 16:00
 *  @Description:房源具体信息服务层
 */
@Service("houseDetailService")
public class HouseDetailService {

    @Autowired
    private HouseDetailDao houseDetailDao;

    /**
     *  @author: huang.zh
     *  @Date: 2019/9/21 0021 16:01
     *  @Description:储存房源简要信息
     */
    public void saveSample(List<JSONObject> list){
        String sql = "insert into housedetail (houseCode,title,price,unitPrice,area,propertyRights,ladderRatio," +
                "listingTime,mainUse,imageSrc,construct,houseYears,buildingStructure,mortgage,buildType,authority,internalArea," +
                "hasElevator,floor,lastTransactionTime,oriented,decoration,apartment,belong,subway) values(?,?,?,?,?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?,?,?,?,?,?,?)";
        List<Object[]> params = new ArrayList<>();
        for (JSONObject data : list){
            JSONObject detail = data.getJSONObject("detail");
            params.add(new Object[]{
                    data.getString("houseCode"),
                    data.getString("titles"),
                    data.getString("price"),
                    data.getString("unitPrice"),
                    detail.getString("area"),
                    detail.getString("propertyRights"),
                    detail.getString("ladderRatio"),
                    detail.getString("listingTime"),
                    detail.getString("mainUse"),
                    LemonUtil.groupString(detail.getJSONArray("imageSrc")),
                    detail.getString("construct"),
                    detail.getString("houseYears"),
                    detail.getString("buildingStructure"),
                    detail.getString("mortgage"),
                    detail.getString("buildType"),
                    detail.getString("authority"),
                    detail.getString("internalArea"),
                    detail.getString("hasElevator"),
                    detail.getString("floor"),
                    detail.getString("lastTransactionTime"),
                    detail.getString("oriented"),
                    detail.getString("decoration"),
                    detail.getString("apartment"),
                    detail.getString("belong"),
                    detail.getString("subway")
            });
        }
        houseDetailDao.batchSaveOrUpdate(params,sql);
    }

    public IPage<HouseDetail> getList(Page page, HouseDetail house){
        QueryWrapper<HouseDetail> wrapper = new QueryWrapper<>();
        if (LemonUtil.isNotBlank(house.getHouseCode()))
            wrapper.eq("houseCode",house.getHouseCode());
        if (LemonUtil.isNotBlank(house.getBelong()))
            wrapper.like("belong",house.getBelong());
        if (LemonUtil.isNotBlank(house.getSubway()))
            wrapper.isNotNull("subway");
        return houseDetailDao.getList(page,wrapper);
    }


}

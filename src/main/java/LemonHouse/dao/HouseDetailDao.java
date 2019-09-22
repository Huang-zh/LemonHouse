package LemonHouse.dao;

import LemonHouse.Entity.HouseDetail;
import LemonHouse.Mapper.HouseDetailMapper;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 *  @author: huang.zh
 *  @Date: 2019/9/21 0021 15:48
 *  @Description:房屋具体信息dao层操作类
 */

@Repository("houseDetailDao")
public class HouseDetailDao extends BaseDao{

    @Autowired
    private HouseDetailMapper houseDetailMapper;

    public void batchSaveOrUpdate(List<Object[]> list,String sql){
        jdbcTemplate.batchUpdate(sql,list);
    }

    public JSONObject findByHouseCode(String houseCode){
        String sql = "select * from housedetail where houseCode = '"+houseCode+"'";
        return jdbcTemplate.queryForObject(sql,JSON_ROW_MAPPER);
    }

    public IPage<HouseDetail> getList(Page page, QueryWrapper<HouseDetail> wrapper){
        return houseDetailMapper.selectPage(page, wrapper);
    }


}

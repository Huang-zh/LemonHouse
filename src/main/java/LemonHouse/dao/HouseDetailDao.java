package LemonHouse.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 *  @author: huang.zh
 *  @Date: 2019/9/21 0021 15:48
 *  @Description:房屋具体信息dao层操作类
 */

@Repository("houseDetailDao")
public class HouseDetailDao extends BaseDao{

    public void batchSaveOrUpdate(List<Object[]> list,String sql){
        jdbcTemplate.batchUpdate(sql,list);
    }

    public JSONObject findByHouseCode(String houseCode){
        String sql = "select * from housedetail where houseCode = '"+houseCode+"'";
        return jdbcTemplate.queryForObject(sql,JSON_ROW_MAPPER);
    }


}

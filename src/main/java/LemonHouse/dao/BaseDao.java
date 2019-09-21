package LemonHouse.dao;


import LemonHouse.utils.JsonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *  @author: huang.zh
 *  @Date: 2019/8/24 0024 0:14
 *  @Description:数据库公用操作类，主要用于共享jdbcTemplate
 */
public class BaseDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public JsonRowMapper JSON_ROW_MAPPER = new JsonRowMapper();
    /**
     *  @author: huang.zh
     *  @Date: 2019/8/24 0024 0:18
     *  @Description:通用方法，用于执行插入和修改数据操作
     */
    public boolean execute(String sql){
        try{
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

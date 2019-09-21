package LemonHouse.controler;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    public HttpServletRequest request;
    public HttpServletResponse response;
    public ModelAndView modelAndView;

    public Map<String,Object> success(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","操作成功");
        map.put("success",true);
        return map;
    }

    public Map<String,Object> error(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",500);
        map.put("msg","操作失败");
        map.put("success",false);
        return map;
    }
}

package LemonHouse.controller;

import LemonHouse.Entity.HouseDetail;
import LemonHouse.service.HouseDetailService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/houseDetail")
public class HouseDetailController extends BaseController {

    @Autowired
    private HouseDetailService houseDetailService;

    @RequestMapping("/page")
    @ResponseBody
    public Object page(Page page,HouseDetail houseDetail){
        return houseDetailService.getList(page,houseDetail);
    }
}

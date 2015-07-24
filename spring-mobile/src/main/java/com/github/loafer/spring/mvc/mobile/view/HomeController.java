package com.github.loafer.spring.mvc.mobile.view;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaojh.
 */
@Controller
public class HomeController {

    @RequestMapping("home")
    public String home(Device device){
        return "home";
    }
}

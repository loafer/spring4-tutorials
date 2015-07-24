package com.github.loafer.spring.mvc.mobile.device;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaojh.
 */
@Controller
@RequestMapping("/")
public class DeviceResolveController {

    @RequestMapping("resolve")
    @ResponseBody
    public String deviceResolve(Device device){
        if(device.isMobile()){
            return "hello mobile user!";
        }else if (device.isTablet()){
            return "hello tablet user!";
        }else{
            return "hello desktop user!";
        }
    }
}

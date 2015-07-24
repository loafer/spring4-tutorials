package com.github.loafer.spring.mvc.intercepter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaojh.
 */
@Controller
@RequestMapping("/interceptors")
public class InterceptorController {

    @RequestMapping("welcome")
    @ResponseBody
    public String welcome(){
        return "opening time";
    }
}

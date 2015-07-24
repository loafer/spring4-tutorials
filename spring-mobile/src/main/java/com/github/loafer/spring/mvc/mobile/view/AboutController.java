package com.github.loafer.spring.mvc.mobile.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhaojh.
 */
@Controller
public class AboutController {

    @RequestMapping("about")
    public String about(){
        return "about";
    }
}

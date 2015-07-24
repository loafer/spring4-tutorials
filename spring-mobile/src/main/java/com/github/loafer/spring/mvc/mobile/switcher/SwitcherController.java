package com.github.loafer.spring.mvc.mobile.switcher;

import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaojh.
 */
@Controller
public class SwitcherController {

    @RequestMapping("/")
    @ResponseBody
    public String hello(SitePreference sitePreference){

        switch (sitePreference){
            case TABLET:
                return "Hello World for Tablet user";
            case MOBILE:
                return "Hello World for Mobile user";
            default:
                return "Hello World for Normal user";
        }
    }
}

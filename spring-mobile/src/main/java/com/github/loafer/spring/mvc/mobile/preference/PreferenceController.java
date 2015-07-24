package com.github.loafer.spring.mvc.mobile.preference;

import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaojh.
 */
@Controller
public class PreferenceController{

    @RequestMapping("")
    @ResponseBody
    public String preference(SitePreference sitePreference){
        switch (sitePreference){
            case MOBILE:
                return "Site preference is mobile";
            case TABLET:
                return "Site preference is tablet";
            case NORMAL:
                return "Site preference is normal";
            default:
                return "no site preference";
        }
    }
}

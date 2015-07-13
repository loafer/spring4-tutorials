package com.github.loafer.spring.mvc.convert;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author zhaojh.
 */
@Controller
@RequestMapping("/convert")
public class ConvertController {

    @RequestMapping("page")
    public String showTestPage(){
        return "/convert/page";
    }

    @RequestMapping("primitive")
    @ResponseBody
    public String primitive(Integer value){
        return "Converted primitive " + value;
    }

    @RequestMapping("date/{date}")
    @ResponseBody
    public String date(@PathVariable("date") Date date){
        return "Converted date " + date;
    }

    @RequestMapping("collection")
    @ResponseBody
    public String collection(@RequestParam List<Integer> values){
        return "Converted collection " + values;
    }

    @RequestMapping("collection2")
    @ResponseBody
    public String collection2(@RequestParam List<Date> values){
        System.out.println(values);
        return "Converted collection " + values;
    }

    @RequestMapping("bean")
    @ResponseBody
    public String bean(JavaBean bean){
        return "Converted " + bean;
    }

    @RequestMapping("bind")
    @ResponseBody
    public String bind(@ModelAttribute("bean1") JavaBean bean1, @ModelAttribute("bean2") JavaBean bean2){
        return "Converted [" + bean1 + "] and [" + bean2 + "]";
    }

    @InitBinder("bean1")
    private void initBean1(WebDataBinder binder){
        binder.setFieldDefaultPrefix("bean1.");
    }

    @InitBinder("bean2")
    private void initBean2(WebDataBinder binder){
        binder.setFieldDefaultPrefix("bean2.");
    }
}

package com.github.loafer.spring.mvc.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaojh.
 */
@Controller
@RequestMapping("/exceptions")
public class ExceptionController {

    @RequestMapping("bizexception")
    @ResponseBody
    public String bizException(){
        throw new BizException("biz.not.found", new Object[]{"Tom"});
    }
}

package com.github.loafer.spring.mvc.validation;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @author zhaojh.
 */
@Controller
public class ValidationController {

    @RequestMapping("validation")
    @ResponseBody
    public String validate(@Valid JavaBean bean, BindingResult result){
        if(result.hasErrors()){
            return "Object has validation errors";
        }else{
            return "No errors";
        }
    }
}

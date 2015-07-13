package com.github.loafer.spring.mvc.modelattribute;

import com.github.loafer.spring.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author zhaojh.
 */
@Controller
@RequestMapping("/modelattribute")
public class ModelAttributeController {

    /**
     * 标记有@ModelAttribute方法会在所有标记有@RequestMapping方法之前执行，
     * 作用就是向Model中放入一个值（相当于mode.addAttribute("key",value)）。
     * 不适合在含有多个@RequestMapping注解的Controller中使用。
     *
     * 当@ModelAttribute用来标记方法参数时，标不标记效果都一样。
     *
     * @return
     */
    @ModelAttribute
    private User findUser(){
        User user = new User();
        user.setName("Marry");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/user")
    public String showEditForm(){
        return "/user/edit";
    }
}

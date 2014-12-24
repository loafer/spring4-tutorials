package com.github.loafer.user;

import com.github.loafer.user.constraints.ValidatePassword;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 演示Controller中的方法验证
 * 注意：Controller默认支持参数级别的方法验证，
 *      若想实现Cross-parameter constraints，除了
 *      配置MethodValidationPostProcessor外，还需要在
 *      Controller类上添加@Validated
 *
 * @author zhaojh.
 */
@Controller
@Validated
@RequestMapping("/users")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping(
            method = RequestMethod.POST,
            produces = "application/json;charset=utf-8"
    )
    @ResponseBody
    public ResponseResult save(User user){
        logger.info("===>{}", user);
        userService.save(user);
        return new ResponseResult(true);
    }

    /**
     *
     * @param userid
     * @param newPassword   也可以通过@ModelAttribute("newPassword")方式获取页面传值
     * @param confirmation  也可以通过@ModelAttribute("confirmation")方式获取页面传值
     * @return
     */
    @RequestMapping(
            value = "/{id}/password",
            method = RequestMethod.POST,
            produces = "application/json;charset-utf-8"
    )
    @ValidatePassword
    public ResponseResult changePassword(@PathVariable("id") String userid,
                                         String newPassword,
                                         String confirmation){
        System.out.println("===>userid: " + userid);
        System.out.println("===>newPassword: " + newPassword);
        System.out.println("===>confirmation: " + confirmation);
        userService.changePassword(newPassword, confirmation);
        return new ResponseResult(true);
    }
}

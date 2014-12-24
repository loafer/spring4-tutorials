package com.github.loafer;

import com.github.loafer.user.User;
import com.github.loafer.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author zhaojh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-config-method-validator.xml"})
public class MethodValidateTest {
    @Resource
    private UserService userService;

    @Test
    public void testSave(){
        User user = new User();
//        user.setId(System.currentTimeMillis());
//        user.setName("loafer");
//        user.setPassword("123456");
        userService.save(user);
    }
}

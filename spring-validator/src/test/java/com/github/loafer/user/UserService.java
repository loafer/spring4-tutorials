package com.github.loafer.user;

import com.github.loafer.user.constraints.ValidatePassword;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaojh.
 */
@Validated
@Component
public class UserService {
    private Map<Long, User> container = new HashMap<Long, User>();

    public void save(@Valid User user){
        if(user.getId() == null){
            user.setId(System.currentTimeMillis());
        }

        container.put(user.getId(), user);
    }


    public void changePassword(String newPassword, String confirmation){

    }
}

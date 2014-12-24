package com.github.loafer.user;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author zhaojh.
 */
public class User {
    private Long id;

    @NotNull(message = "{user.name.null}")
    @NotEmpty(message = "user.name.null")
    @Length(min = 5, max = 20, message = "{user.name.length.illegal}")
    @Pattern(regexp = "[a-zA-Z]{5,20}", message = "{user.name.illegal}")
    private String name;

    @NotNull(message = "{user.password.null}")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package com.github.loafer.upm.users.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhaojh.
 */
@Entity
@Table(name = "upm_users")
public class User {
    @Id
    private String id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_realname", length = 800)
    private String realName;
    @Column(name = "user_age")
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}

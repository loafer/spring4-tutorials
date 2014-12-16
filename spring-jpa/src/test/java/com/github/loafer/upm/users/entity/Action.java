package com.github.loafer.upm.users.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhaojh.
 */
@Entity
@Table(name = "upm_actions")
public class Action {
    @Id
    private String id;
    @Column(name = "action_code", length = 100)
    private String code;
    @Column(name = "action_name", length = 200)
    private String name;
    @Column(name = "action_icon", length = 45)
    private String icon;
    @Column(name = "action_index")
    private int index;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

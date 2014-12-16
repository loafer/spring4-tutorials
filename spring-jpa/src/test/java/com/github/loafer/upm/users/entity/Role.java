package com.github.loafer.upm.users.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhaojh.
 */
@Entity
@Table(name = "upm_roles")
public class Role {
    @Id
    private String id;
    @Column(name = "role_name", length = 200)
    private String name;
    @Column(name = "role_desc", length = 500)
    private String description;
    @Column(name = "application_id", length = 32)
    private String applicationId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
}

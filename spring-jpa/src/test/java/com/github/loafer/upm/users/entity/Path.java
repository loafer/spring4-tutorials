package com.github.loafer.upm.users.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author zhaojh.
 */
@Entity
@Table(name = "upm_paths")
public class Path {
    @Id
    private String id;
    @Column(name = "application_id", length = 32)
    private String applicationId;
    @Column(name = "path_name", length = 500)
    private String name;
    @Column(name = "path", length = 2000)
    private String path;
    @Column(name = "path_icon", length = 100)
    private String icon;
    @Column(name = "pid", length = 32)
    private String pid;
    @Column(name = "path_index")
    private Integer index;
    @ManyToMany
    @JoinTable(
        name = "upm_actionsInPath",
        joinColumns = @JoinColumn(name = "path_id"),
        inverseJoinColumns = @JoinColumn(name = "action_id")
    )
    private List<Action> actions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}

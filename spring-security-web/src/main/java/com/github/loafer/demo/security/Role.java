package com.github.loafer.demo.security;

/**
 * @author zhaojh.
 */
public class Role {
  private String id;
  private String name;
  private String chsName;

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

  public String getChsName() {
    return chsName;
  }

  public void setChsName(String chsName) {
    this.chsName = chsName;
  }

  @Override
  public String toString() {
    return "Role{" +
           "id='" + id + '\'' +
           ", name='" + name + '\'' +
           ", chsName='" + chsName + '\'' +
           '}';
  }
}

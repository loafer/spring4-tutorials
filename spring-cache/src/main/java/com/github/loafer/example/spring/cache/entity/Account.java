package com.github.loafer.example.spring.cache.entity;

/**
 * @author zhaojh.
 */
public class Account {
  private String id;
  private String name;
  private String email;

  public Account(String id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Account{" +
           "id='" + id + '\'' +
           ", name='" + name + '\'' +
           ", email='" + email + '\'' +
           '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Account account = (Account) o;

    if (!id.equals(account.id)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}

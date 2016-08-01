package com.github.loafer.example.spring.redis.bean;

import java.io.Serializable;

/**
 * @author zhaojh.
 */
public class Person implements Serializable{
  private String firstName;
  private String lastName;

  public Person() {}

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "Person{" +
           "firstName='" + firstName + '\'' +
           ", lastName='" + lastName + '\'' +
           '}';
  }
}

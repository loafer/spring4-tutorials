package com.github.loafer.car.entity;

import com.github.loafer.car.DriverChecks;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;

/**
 * @author zhaojh.
 */
public class Driver extends Person {
    @Min(value = 18, message = "you have to be 18 to drive a car", groups = DriverChecks.class)
    private int age;

    @AssertTrue(message = "you first have to pass the driving test", groups = DriverChecks.class)
    private boolean hasDrivingLicense;

    public Driver(String name) {
        super(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void passDrivingTest(boolean b) {
        this.hasDrivingLicense = b;
    }
}

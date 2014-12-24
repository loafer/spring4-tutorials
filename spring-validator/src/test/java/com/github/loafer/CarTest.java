package com.github.loafer;

import static org.hamcrest.CoreMatchers.*;

import com.github.loafer.car.CarChecks;
import com.github.loafer.car.DriverChecks;
import com.github.loafer.car.entity.Car;
import com.github.loafer.car.entity.Driver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.util.Set;

/**
 * @author zhaojh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-config-bean-validator.xml"})
public class CarTest {
    @Resource
    private ValidatorFactory validatorFactory;
    private Validator validator;

    @Before
    public void setup(){
        validator = validatorFactory.getValidator();
    }

    @Test
    public void testManufacturerIsNull(){
        Car car = new Car(null, "DD-AB-123", 2);
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

        Assert.assertEquals(1, constraintViolations.size());
        String message = constraintViolations.iterator().next().getMessage();
        System.out.println(message);
    }

    @Test
    public void testLicensePlateShort(){
        Car car = new Car("Morris", "D", 2);
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        Assert.assertEquals(1, constraintViolations.size());
        String message = constraintViolations.iterator().next().getMessage();
        System.out.println(message);
    }

    @Test
    public void testSeatCount(){
        Car car = new Car("Morris", "DD-AB-123", 1);
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        Assert.assertEquals(1, constraintViolations.size());
        String message = constraintViolations.iterator().next().getMessage();
        System.out.println(message);
    }

    @Test
    public void testCarIsValid(){
        Car car = new Car("Morris", "DD-AB-123", 4);
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        Assert.assertEquals(0, constraintViolations.size());
    }

    @Test
    public void testDriveAway(){
        Car car = new Car("Morris", "DD-AB-123", 4);
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        Assert.assertEquals(0, constraintViolations.size());

        // but has it passed the vehicle inspection?
        constraintViolations = validator.validate(car, CarChecks.class);
        Assert.assertEquals(1, constraintViolations.size());
        Assert.assertThat(constraintViolations.iterator().next().getMessage(), is("The car has to pass the vehicle inspection first"));

        // let's go to the vehicle inspection
        car.setPassedVehicleInspection(true);
        constraintViolations = validator.validate(car, CarChecks.class);
        Assert.assertEquals(0, constraintViolations.size());

        // now let's add a driver. He is 18, but has not passed the driving test yet
        Driver driver = new Driver("John");
        driver.setAge(18);
        car.setDriver(driver);
        constraintViolations = validator.validate(car, DriverChecks.class);
        Assert.assertEquals(1, constraintViolations.size());
        Assert.assertThat(constraintViolations.iterator().next().getMessage(), is("you first have to pass the driving test"));

        // ok, John passes the test
        driver.passDrivingTest(true);
        constraintViolations = validator.validate(car, DriverChecks.class);
        Assert.assertEquals(0, constraintViolations.size());

        Assert.assertEquals(0, validator.validate(car, Default.class, CarChecks.class, DriverChecks.class).size());
    }

    @Test
    public void testLicensePlateNotUpperCase(){
        Car car = new Car("Morris", "DD-ab-123", 2);
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        Assert.assertEquals(1, constraintViolations.size());
        Assert.assertThat(constraintViolations.iterator().next().getMessage(), is("Case mode must be UPPER."));
    }
}

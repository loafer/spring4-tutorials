package com.github.loafer.car.entity;

import com.github.loafer.car.CarChecks;
import com.github.loafer.car.constraints.CaseMode;
import com.github.loafer.car.constraints.CheckCase;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author zhaojh.
 */
public class Car {
    @NotNull
    private String manufacturer;

    @NotNull
    @Size(min = 2, max = 14)
    @CheckCase(value = CaseMode.UPPER, message = "Case mode must be UPPER.")
    private String licensePlate;

    @Min(2)
    private int seatCount;

    @AssertTrue(message = "The car has to pass the vehicle inspection first", groups = CarChecks.class)
    private boolean passedVehicleInspection;

    @Valid
    private Driver driver;

    public Car(String manufacturer, String licensePlate, int seatCount) {
        this.manufacturer = manufacturer;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
    }

    public void setPassedVehicleInspection(boolean passedVehicleInspection) {
        this.passedVehicleInspection = passedVehicleInspection;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}

package com.github.loafer.car;

import com.github.loafer.car.entity.Driver;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * @author zhaojh.
 */
@GroupSequence({Default.class, CarChecks.class, Driver.class})
public interface OrderChecks {
}

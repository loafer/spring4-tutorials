package com.github.loafer.spring.mvc.validation;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author zhaojh.
 */
public class JavaBean {
    @NotNull
    @Max(value = 5, message = "number.max")
    private Integer number;

    @NotNull
    @Future
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

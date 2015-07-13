package com.github.loafer.spring.mvc.convert;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author zhaojh.
 */
public class DateFormatter implements Formatter<Date> {

    private String pattern;

    public DateFormatter(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        final SimpleDateFormat dateFormat = createDateFormat(locale);
        System.out.println("===>" + text);
        return dateFormat.parse(text);
    }

    @Override
    public String print(Date date, Locale locale) {
        final SimpleDateFormat dateFormat = createDateFormat(locale);
        System.out.println("=====> " + dateFormat.format(date));
        return dateFormat.format(date);
    }

    private SimpleDateFormat createDateFormat(final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat(this.pattern, locale);
        dateFormat.setLenient(false);
        return dateFormat;
    }
}

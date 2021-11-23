package com.example.springerrorhandling.core.constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofPattern;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 6:04 PM
 */
public interface AppConstant {

    public interface DateFormatters {
        public SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        public static final DateTimeFormatter DATE_TIME_FORMATTER = ofPattern("yyyy-MM-dd HH:mm");
        public static final DateTimeFormatter DATE_TIME_LONG_FORMATTER = ofPattern("yyyy-MM-dd HH:mm:ss");
        public static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
        public static final String defaultDateTimeFormatter = "yyyy-MM-dd HH:mm:ss";
        //        public static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        public static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        public static final DateFormat dateFormat_ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        public static final DateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        public static final DateFormat styleTime = new SimpleDateFormat("MMM dd, HH:mm a");
    }

    public interface Message {
        public static final String SUCCESS = "Success";
    }
}

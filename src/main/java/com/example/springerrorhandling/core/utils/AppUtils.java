package com.example.springerrorhandling.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 5:57 PM
 */
@Slf4j
public class AppUtils {

    private static ObjectMapper mapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(new Jdk8Module());
        return mapper;
    }

    public static String toJson(Type type) {
        try {
            return mapper().writeValueAsString(type);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error occurred serializing object to json string, error => " + e.getMessage());
        }
    }

    public static <T> String toJson(T t) {
        try {
            return mapper().writeValueAsString(t);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error occurred serializing object to json string, error => " + e.getMessage());
        }
    }


    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return mapper().readValue(json, clazz);
        } catch (IOException e) {
            log.error("Error occurred deserializing object to json string >> {}", e.getMessage());
        }
        return null;
    }

    public static <T, K, V> T fromJson(Map<K, V> json, Class<T> clazz) {
        return mapper().convertValue(json, clazz);
    }

    public static <T, K, V> T fromJson(Map<K, V> json, TypeReference<T> clazz) {
        return mapper().convertValue(json, clazz);
    }

    public static <T> T fromJson(T json, TypeReference<T> clazz) {
        return mapper().convertValue(json, clazz);
    }

    public static <T> List<T> readList(String str, Class<T> type) {
        return readList(str, ArrayList.class, type);
    }

    private static <T> List<T> readList(String str, Class<? extends Collection> type, Class<T> elementType) {
        try {
            return mapper().readValue(str, mapper().getTypeFactory().constructCollectionType(type, elementType));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

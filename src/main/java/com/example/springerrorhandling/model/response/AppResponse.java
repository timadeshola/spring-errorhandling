package com.example.springerrorhandling.model.response;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 6:10 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AppResponse<T> implements Serializable {

    private T data;
    private String message;
    private HttpStatus status;
    private Object error;
}

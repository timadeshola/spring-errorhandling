package com.example.springerrorhandling.core.exceptions.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 5:55 PM
 */
@Setter
@Getter
@NoArgsConstructor
@Builder
public class ErrorDetails implements Serializable {

    private LocalDateTime timestamp;
    private String message;
    private String details;
    private int code;
    private List<ValidationError> validation;

    public ErrorDetails(LocalDateTime timestamp, String message, String details, int code) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.code = code;
    }

    public ErrorDetails(LocalDateTime timestamp, String message, String details, int code, List<ValidationError> validation) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.code = code;
        this.validation = validation;
    }
}

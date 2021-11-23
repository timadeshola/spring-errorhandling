package com.example.springerrorhandling.core.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 8:03 PM
 */
@Getter
@NoArgsConstructor
public class EmailNotFoundException extends RuntimeException {

    protected String message;
    protected HttpStatus status;

    public EmailNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public EmailNotFoundException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}

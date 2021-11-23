package com.example.springerrorhandling.core.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 8:23 PM
 */
@Getter
@NoArgsConstructor
public class ServiceException extends RuntimeException {

    private String message;

    public ServiceException(String message) {
        super(message);
        this.message = message;
    }

}

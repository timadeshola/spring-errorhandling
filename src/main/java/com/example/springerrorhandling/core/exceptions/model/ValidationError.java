package com.example.springerrorhandling.core.exceptions.model;

import lombok.*;

import java.io.Serializable;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 5:55 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ValidationError implements Serializable {
    private Object rejectedValue;
    private String field;
    private String objectName;
}

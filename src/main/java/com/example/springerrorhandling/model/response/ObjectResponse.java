package com.example.springerrorhandling.model.response;

import lombok.*;

import java.io.Serializable;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 12/1/21
 * Time: 4:10 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ObjectResponse implements Serializable {

    private String message;
    private Integer counter;
}

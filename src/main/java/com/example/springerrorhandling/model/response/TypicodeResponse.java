package com.example.springerrorhandling.model.response;

import lombok.*;

import java.io.Serializable;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 8:11 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TypicodeResponse implements Serializable {

    private Integer id;
    private Integer userId;
    private String title;
    private Boolean completed;
}

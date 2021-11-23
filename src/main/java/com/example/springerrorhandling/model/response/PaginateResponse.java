package com.example.springerrorhandling.model.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 7:49 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PaginateResponse<T> implements Serializable {

    private List<T> content;
    private long totalElements;
}

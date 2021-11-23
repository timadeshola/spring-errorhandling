package com.example.springerrorhandling.model.response;

import lombok.*;

import java.io.Serializable;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 6:20 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserResponse implements Serializable {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String empId;
    private String status;
    private String dateCreated;
    private String dateUpdated;
}

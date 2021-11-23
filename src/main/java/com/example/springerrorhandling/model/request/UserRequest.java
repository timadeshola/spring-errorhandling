package com.example.springerrorhandling.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
public class UserRequest implements Serializable {

    @NotBlank(message = "First name cannot be empty")
    @Size(message = "First name character length cannot be less than 4 and more than 45", min = 4, max = 45)
    private String firstName;

    @NotBlank(message = "First name cannot be empty")
    @Size(message = "Last name character length cannot be less than 4 and more than 45", min = 4, max = 45)
    private String lastName;

    @NotBlank(message = "Email address cannot be empty")
    @Size(message = "Email address character length cannot be less than 4 and more than 120", min = 4, max = 120)
    private String email;

}

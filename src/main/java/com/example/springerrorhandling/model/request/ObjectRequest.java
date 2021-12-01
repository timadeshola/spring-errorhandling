package com.example.springerrorhandling.model.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 12/1/21
 * Time: 4:11 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ObjectRequest implements Serializable {

    @NotNull(message = "Please enter a valid message")
    private String message;

    @Pattern(regexp = "[+-]?[0-9]+", message = "You entered a wrong format")
    @NotNull
    private String counter;
}

package com.example.springerrorhandling.model.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.io.Serializable;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 8:07 PM
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "app.typicode")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TypicodeConfig implements Serializable {

    private String baseUrl;
    private String all;
    private String id;
}

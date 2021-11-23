package com.example.springerrorhandling.service.impl;

import com.example.springerrorhandling.core.exceptions.ApiCallException;
import com.example.springerrorhandling.core.exceptions.CustomException;
import com.example.springerrorhandling.model.config.TypicodeConfig;
import com.example.springerrorhandling.model.response.TypicodeResponse;
import com.example.springerrorhandling.service.TypicodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 8:10 PM
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TypicodeServiceImpl implements TypicodeService {

    private final RestTemplate restTemplate;
    private final TypicodeConfig config;

    @Override
    public TypicodeResponse fetch(Integer id) {

        if (Objects.isNull(id)) {
            throw new CustomException("ID cannot be empty", HttpStatus.BAD_REQUEST);
        }

        try {
            String url = config.getBaseUrl() + config.getId();
            UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url)
                    .path(String.valueOf(id))
                    .build();
            HttpHeaders header = new HttpHeaders();
            header.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<?> entity = new HttpEntity<>(header);
            return restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity, TypicodeResponse.class).getBody();
        } catch (HttpClientErrorException e) {
            throw new ApiCallException(e.getMessage(), e.getStatusCode());
        }
    }

    @Override
    public List<TypicodeResponse> fetchAll() {
        try {
            String url = config.getBaseUrl() + config.getAll();
            HttpHeaders header = new HttpHeaders();
            header.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<?> entity = new HttpEntity<>(header);
            return restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<TypicodeResponse>>() {
            }).getBody();
        } catch (HttpClientErrorException e) {
            throw new ApiCallException(e.getMessage(), e.getStatusCode());
        }
    }

}

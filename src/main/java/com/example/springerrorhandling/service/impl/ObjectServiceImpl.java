package com.example.springerrorhandling.service.impl;

import com.example.springerrorhandling.model.request.ObjectRequest;
import com.example.springerrorhandling.model.response.ObjectResponse;
import com.example.springerrorhandling.service.ObjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 12/1/21
 * Time: 4:11 PM
 */
@Service
@RequiredArgsConstructor
public class ObjectServiceImpl implements ObjectService {

    List<ObjectResponse> responses = new ArrayList<>();

    @Override
    public ObjectResponse postObject(ObjectRequest request) {
        ObjectResponse response = ObjectResponse.builder()
                .message(request.getMessage())
                .counter(Integer.valueOf(request.getCounter()))
                .build();
        responses.add(response);
        return response;
    }

    @Override
    public List<ObjectResponse> fetchAll() {
        return responses;
    }
}

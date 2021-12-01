package com.example.springerrorhandling.service;

import com.example.springerrorhandling.model.request.ObjectRequest;
import com.example.springerrorhandling.model.response.ObjectResponse;

import java.util.List;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 12/1/21
 * Time: 4:10 PM
 */
public interface ObjectService {

    public ObjectResponse postObject(ObjectRequest request);

    public List<ObjectResponse> fetchAll();
}

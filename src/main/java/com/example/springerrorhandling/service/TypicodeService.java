package com.example.springerrorhandling.service;

import com.example.springerrorhandling.model.response.TypicodeResponse;

import java.util.List;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 8:10 PM
 */
public interface TypicodeService {

    public TypicodeResponse fetch(Integer id);

    public List<TypicodeResponse> fetchAll();
}

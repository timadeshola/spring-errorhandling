package com.example.springerrorhandling.service;

import com.example.springerrorhandling.persistence.entity.Todo;

import java.util.List;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 8:29 PM
 */
public interface TodoService {

    Todo createTodo(Integer id);

    List<Todo> createTodo();

}

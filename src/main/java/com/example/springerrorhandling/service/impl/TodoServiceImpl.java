package com.example.springerrorhandling.service.impl;

import com.example.springerrorhandling.core.exceptions.CustomException;
import com.example.springerrorhandling.core.exceptions.ServiceException;
import com.example.springerrorhandling.core.utils.ModelMapperUtils;
import com.example.springerrorhandling.model.response.TypicodeResponse;
import com.example.springerrorhandling.persistence.entity.Todo;
import com.example.springerrorhandling.persistence.repository.TodoRepository;
import com.example.springerrorhandling.service.TodoService;
import com.example.springerrorhandling.service.TypicodeService;
import com.google.common.collect.Iterables;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 8:30 PM
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final TypicodeService typicodeService;

    @Override
    public Todo createTodo(Integer id) {
        TypicodeResponse response = typicodeService.fetch(id);
        Todo todo = ModelMapperUtils.map(response, Todo.class);
        todoRepository.findById(id).ifPresent(data -> {
            throw new CustomException("Todo already exist on database", HttpStatus.NOT_FOUND);
        });
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> createTodo() {
        List<TypicodeResponse> responses = typicodeService.fetchAll();
        if (responses.isEmpty()) {
            throw new CustomException("Their is no record available on the API", HttpStatus.NO_CONTENT);
        }

        long start = System.nanoTime();
        log.info("start @ : {}", start);
        log.info("response size: {}", responses.size());
        Iterables.paddedPartition(responses, 20).forEach((data) -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new ServiceException(e.getMessage());
            }
            List<Todo> todos = ModelMapperUtils.mapAll(data, Todo.class);
            todoRepository.saveAll(todos);
        });
        log.info("end @ : {}", (System.nanoTime() - start) / 1000000000);
        return todoRepository.findAll();

    }
}

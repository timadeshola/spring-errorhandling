package com.example.springerrorhandling.service.impl;

import com.example.springerrorhandling.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 9:05 PM
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SchedulerServiceImpl implements CommandLineRunner {

    private final TodoService todoService;

    @Override
    public void run(String... args) throws Exception {
        try {
            todoService.createTodo();
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
        }
    }
}

package com.example.springerrorhandling.persistence.repository;

import com.example.springerrorhandling.persistence.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 8:30 PM
 */
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}

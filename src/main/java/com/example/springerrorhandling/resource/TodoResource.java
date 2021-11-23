package com.example.springerrorhandling.resource;

import com.example.springerrorhandling.model.response.AppResponse;
import com.example.springerrorhandling.model.response.TypicodeResponse;
import com.example.springerrorhandling.persistence.entity.Todo;
import com.example.springerrorhandling.service.TodoService;
import com.example.springerrorhandling.service.TypicodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.springerrorhandling.core.constants.AppConstant.Message.SUCCESS;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 10:31 PM
 */
@RestController
@RequestMapping("todos")
@RequiredArgsConstructor
public class TodoResource {

    private final TypicodeService typicodeService;
    private final TodoService todoService;


    @GetMapping("all")
    public ResponseEntity<AppResponse<List<TypicodeResponse>>> fetchAll() {
        List<TypicodeResponse> response = typicodeService.fetchAll();
        return ResponseEntity.ok().body(AppResponse.<List<TypicodeResponse>>builder()
                .data(response)
                .message(SUCCESS)
                .status(HttpStatus.OK)
                .build());
    }

    @GetMapping
    public ResponseEntity<AppResponse<TypicodeResponse>> fetch(@RequestParam(required = false) Integer id) {
        TypicodeResponse response = typicodeService.fetch(id);
        return ResponseEntity.ok().body(AppResponse.<TypicodeResponse>builder()
                .data(response)
                .message(SUCCESS)
                .status(HttpStatus.OK)
                .build());
    }


    @PostMapping("all")
    public ResponseEntity<AppResponse<List<Todo>>> saveAll() {
        List<Todo> response = todoService.createTodo();
        return ResponseEntity.ok().body(AppResponse.<List<Todo>>builder()
                .data(response)
                .message(SUCCESS)
                .status(HttpStatus.OK)
                .build());
    }

    @PostMapping
    public ResponseEntity<AppResponse<Todo>> save(@RequestParam(required = false) Integer id) {
        Todo response = todoService.createTodo(id);
        return ResponseEntity.ok().body(AppResponse.<Todo>builder()
                .data(response)
                .message(SUCCESS)
                .status(HttpStatus.OK)
                .build());
    }

}

package com.example.springerrorhandling.resource;

import com.example.springerrorhandling.model.request.ObjectRequest;
import com.example.springerrorhandling.model.response.AppResponse;
import com.example.springerrorhandling.model.response.ObjectResponse;
import com.example.springerrorhandling.service.ObjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.springerrorhandling.core.constants.AppConstant.Message.SUCCESS;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 12/1/21
 * Time: 4:13 PM
 */
@RestController
@RequestMapping("messages")
@RequiredArgsConstructor
public class ObjectResource {

    private final ObjectService objectService;

    @PostMapping
    public ResponseEntity<AppResponse<ObjectResponse>> postMessage(@Valid @RequestBody ObjectRequest request) {
        ObjectResponse response = objectService.postObject(request);
        return ResponseEntity.ok().body(AppResponse.<ObjectResponse>builder()
                .data(response)
                .message(SUCCESS)
                .status(HttpStatus.OK)
                .build());
    }

    @GetMapping
    public ResponseEntity<AppResponse<List<ObjectResponse>>> fetchAll() {
        List<ObjectResponse> response = objectService.fetchAll();
        return ResponseEntity.ok().body(AppResponse.<List<ObjectResponse>>builder()
                .data(response)
                .message(SUCCESS)
                .status(HttpStatus.OK)
                .build());
    }

}

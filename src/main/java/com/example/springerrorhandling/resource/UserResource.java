package com.example.springerrorhandling.resource;

import com.example.springerrorhandling.model.request.UserRequest;
import com.example.springerrorhandling.model.response.AppResponse;
import com.example.springerrorhandling.model.response.PaginateResponse;
import com.example.springerrorhandling.model.response.UserResponse;
import com.example.springerrorhandling.service.UserService;
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
 * Date: 11/23/21
 * Time: 9:11 PM
 */
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<AppResponse<UserResponse>> createUser(@RequestBody @Valid UserRequest request) {
        UserResponse response = userService.createUser(request);
        return ResponseEntity.ok().body(AppResponse.<UserResponse>builder()
                .data(response)
                .message(SUCCESS)
                .status(HttpStatus.CREATED)
                .build());
    }

    @PutMapping("{id:[\\d]+}")
    public ResponseEntity<AppResponse<UserResponse>> updateUser(@RequestBody @Valid UserRequest request,
                                                                @PathVariable(required = false) Long id) {
        UserResponse response = userService.updateUser(request, id);
        return ResponseEntity.ok().body(AppResponse.<UserResponse>builder()
                .data(response)
                .message(SUCCESS)
                .status(HttpStatus.OK)
                .build());
    }

    @DeleteMapping("{id:[\\d]+}")
    public ResponseEntity<AppResponse<Boolean>> deleteUser(@PathVariable(required = false) Long id) {
        Boolean response = userService.deleteUser(id);
        return ResponseEntity.ok().body(AppResponse.<Boolean>builder()
                .data(response)
                .message(SUCCESS)
                .status(HttpStatus.OK)
                .build());
    }

    @GetMapping("fetchById/{id:[\\d]+}")
    public ResponseEntity<AppResponse<UserResponse>> fetchUser(@PathVariable(required = false) Long id) {
        UserResponse response = userService.fetchUser(id);
        return ResponseEntity.ok().body(AppResponse.<UserResponse>builder()
                .data(response)
                .message(SUCCESS)
                .status(HttpStatus.OK)
                .build());
    }

    @GetMapping("fetchById")
    public ResponseEntity<AppResponse<UserResponse>> fetchUserById(@RequestParam(required = false) Long id) {
        UserResponse response = userService.fetchUser(id);
        return ResponseEntity.ok().body(AppResponse.<UserResponse>builder()
                .data(response)
                .message(SUCCESS)
                .status(HttpStatus.OK)
                .build());
    }

    @GetMapping("fetchByUsername/{username}")
    public ResponseEntity<AppResponse<UserResponse>> fetchUser(@PathVariable(required = false) String username) {
        UserResponse response = userService.fetchUser(username);
        return ResponseEntity.ok().body(AppResponse.<UserResponse>builder()
                .data(response)
                .message(SUCCESS)
                .status(HttpStatus.OK)
                .build());
    }

    @GetMapping("viewAll")
    public ResponseEntity<AppResponse<List<UserResponse>>> fetchUsers() {
        List<UserResponse> response = userService.fetchUsers();
        return ResponseEntity.ok().body(AppResponse.<List<UserResponse>>builder()
                .data(response)
                .message(SUCCESS)
                .status(HttpStatus.OK)
                .build());
    }

    @GetMapping("paginate")
    public ResponseEntity<AppResponse<PaginateResponse<UserResponse>>> fetchUsers(
            @RequestParam(required = false, defaultValue = "0") int start,
            @RequestParam(required = false, defaultValue = "10") int limit) {
        PaginateResponse<UserResponse> response = userService.fetchUsers(start, limit);
        return ResponseEntity.ok().body(AppResponse.<PaginateResponse<UserResponse>>builder()
                .data(response)
                .message(SUCCESS)
                .status(HttpStatus.OK)
                .build());
    }
}

package com.example.springerrorhandling.service.impl;

import com.example.springerrorhandling.core.exceptions.CustomException;
import com.example.springerrorhandling.core.exceptions.EmailNotFoundException;
import com.example.springerrorhandling.core.utils.ModelMapperUtils;
import com.example.springerrorhandling.model.request.UserRequest;
import com.example.springerrorhandling.model.response.PaginateResponse;
import com.example.springerrorhandling.model.response.UserResponse;
import com.example.springerrorhandling.persistence.entity.User;
import com.example.springerrorhandling.persistence.repository.UserRepository;
import com.example.springerrorhandling.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 6:23 PM
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserResponse createUser(UserRequest request) {

        userRepository.findByEmail(request.getEmail()).ifPresent(user -> {
            throw new EmailNotFoundException(String.format("User with email address %s already exist", request.getEmail()), HttpStatus.CONFLICT);
        });

        return ModelMapperUtils.map(userRepository.save(User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build()), UserResponse.class);
    }

    @Override
    public UserResponse updateUser(UserRequest request, Long id) {
        User user = userRepository.findById(id).<CustomException>orElseThrow(() -> {
            throw new CustomException("User info cannot be found", HttpStatus.NOT_FOUND);
        });

        if (!StringUtils.isBlank(request.getFirstName())) {
            user.setFirstName(request.getFirstName());
        }

        if (!StringUtils.isBlank(request.getLastName())) {
            user.setLastName(request.getLastName());
        }

        return ModelMapperUtils.map(userRepository.save(user), UserResponse.class);
    }

    @Override
    public Boolean deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new CustomException("User detail cannot be found", HttpStatus.NOT_FOUND);
        });
        userRepository.delete(user);
        return true;
    }

    @Override
    public UserResponse fetchUser(Long id) {
        return ModelMapperUtils.map(userRepository.findById(id).<CustomException>orElseThrow(() -> {
            throw new CustomException("User identity cannot be found", HttpStatus.NOT_FOUND);
        }), UserResponse.class);
    }

    @Override
    public UserResponse fetchUser(String username) {
        return ModelMapperUtils.map(userRepository.findByEmail(username).<CustomException>orElseThrow(() -> {
            throw new EmailNotFoundException("User identity cannot be found", HttpStatus.NOT_FOUND);
        }), UserResponse.class);
    }


    @Override
    public List<UserResponse> fetchUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return Collections.emptyList();
        }
        return ModelMapperUtils.mapAll(users, UserResponse.class);
    }

    @Override
    public PaginateResponse<UserResponse> fetchUsers(int start, int limit) {
        Page<User> users = userRepository.findAll(PageRequest.of(start, limit));
        if (users.isEmpty()) {
            return PaginateResponse.<UserResponse>builder()
                    .content(Collections.emptyList())
                    .totalElements(0)
                    .build();
        }
        return PaginateResponse.<UserResponse>builder()
                .content(ModelMapperUtils.mapAll(users.getContent(), UserResponse.class))
                .totalElements(users.getTotalElements())
                .build();
    }

}

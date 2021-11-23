package com.example.springerrorhandling.service;

import com.example.springerrorhandling.model.request.UserRequest;
import com.example.springerrorhandling.model.response.PaginateResponse;
import com.example.springerrorhandling.model.response.UserResponse;

import java.util.List;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 6:20 PM
 */
public interface UserService {

    public UserResponse createUser(UserRequest request);

    public UserResponse updateUser(UserRequest request, Long id);

    public Boolean deleteUser(Long id);

    public UserResponse fetchUser(Long id);

    public UserResponse fetchUser(String username);

    public List<UserResponse> fetchUsers();

    public PaginateResponse<UserResponse> fetchUsers(int start, int limit);

}

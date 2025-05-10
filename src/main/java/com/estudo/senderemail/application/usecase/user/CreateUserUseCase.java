package com.estudo.senderemail.application.usecase.user;

import com.estudo.senderemail.application.dto.Request.CreateUserRequest;
import com.estudo.senderemail.application.dto.Response.UserResponse;
 
public interface CreateUserUseCase {
    UserResponse createUser(CreateUserRequest request);
}
 
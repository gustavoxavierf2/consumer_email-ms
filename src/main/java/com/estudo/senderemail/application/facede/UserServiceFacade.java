package com.estudo.senderemail.application.facede;

import com.estudo.senderemail.application.dto.Request.CreateUserRequest;
import com.estudo.senderemail.application.dto.Response.UserResponse;
import com.estudo.senderemail.application.usecase.user.CreateUserUseCase;
import com.estudo.senderemail.application.usecase.user.GetUsersUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceFacade {
    
    private final CreateUserUseCase createUserUseCase;
    private final GetUsersUseCase getUsersUseCase;

    public UserResponse createUser(CreateUserRequest request) {
        return createUserUseCase.createUser(request);
    }

    public Page<UserResponse> getUsers(Pageable pageable) {
        return getUsersUseCase.getUsers(pageable);
    }
} 
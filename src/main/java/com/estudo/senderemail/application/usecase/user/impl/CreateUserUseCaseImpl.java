package com.estudo.senderemail.application.usecase.user.impl;

import com.estudo.senderemail.application.dto.Request.CreateUserRequest;
import com.estudo.senderemail.application.dto.Response.UserResponse;
import com.estudo.senderemail.application.mapper.UserMapper;
import com.estudo.senderemail.application.usecase.user.CreateUserUseCase;
import com.estudo.senderemail.domain.entity.User;
import com.estudo.senderemail.domain.repository.UserRepository;
import com.estudo.senderemail.infrastructure.messaging.UserCreatedEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;
    private final UserCreatedEventPublisher eventPublisher;

    @Override
    @Transactional
    public UserResponse createUser(CreateUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        var user = UserMapper.INSTANCE.toEntity(request);

        User savedUser = userRepository.save(user);

        eventPublisher.publishUserCreatedEvent(savedUser);

        return UserMapper.INSTANCE.toDto(savedUser);
    }
} 
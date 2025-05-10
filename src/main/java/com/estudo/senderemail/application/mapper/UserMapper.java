package com.estudo.senderemail.application.mapper;

import com.estudo.senderemail.application.dto.Request.CreateUserRequest;
import com.estudo.senderemail.application.dto.Response.UserResponse;
import com.estudo.senderemail.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    
    @Mapping(target = "id", ignore = true)
    User toEntity(CreateUserRequest request);
    
    UserResponse toDto(User user);

    default UUID mapId(UUID id) {
        return id;
    }
} 
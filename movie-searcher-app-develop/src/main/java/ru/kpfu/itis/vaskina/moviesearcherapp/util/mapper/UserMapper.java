package ru.kpfu.itis.vaskina.moviesearcherapp.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.enums.Role;
import ru.kpfu.itis.vaskina.moviesearcherapp.dto.response.UserResponse;
import ru.kpfu.itis.vaskina.moviesearcherapp.model.RoleEntity;
import ru.kpfu.itis.vaskina.moviesearcherapp.model.UserEntity;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = ReviewMapper.class, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    @Mapping(expression = "java(roleEntitiesToRoles(user.getRoles()))", target = "roles")
    UserResponse userToUserResponse(UserEntity user);

    default Set<Role> roleEntitiesToRoles(Set<RoleEntity> roles) {
        return roles.stream()
                .map(RoleEntity::getRole)
                .collect(Collectors.toSet());
    }
}

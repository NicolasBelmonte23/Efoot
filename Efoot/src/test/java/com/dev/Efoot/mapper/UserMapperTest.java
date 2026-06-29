package com.dev.Efoot.mapper;

import com.dev.Efoot.controller.request.CreateUserRequest;
import com.dev.Efoot.controller.response.UserResponse;
import com.dev.Efoot.entity.User;
import junit.framework.TestCase;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class UserMapperTest extends TestCase {
    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public void testToEntity() {
        CreateUserRequest build = CreateUserRequest.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("password")
                .scopes(List.of(1L, 2L))
                .build();
        User entity = mapper.toEntity(build);
        assertNotNull(entity);
        assertEquals(build.getName(), entity.getName());
        assertEquals(build.getEmail(), entity.getEmail());
        assertEquals(build.getPassword(), entity.getPassword());
        assertEquals(build.getScopes().size(), entity.getScopes().size());
    }

    public void testToResponse() {
        User stadium = User.builder()
                .id(1L)
                .name("Stadium A")
                .email("stadium-a@example.com")
                .build();
        UserResponse response = mapper.toResponse(stadium);
        assertNotNull(response);
        assertEquals(stadium.getId(), response.getId());
        assertEquals(stadium.getName(), response.getName());
        assertEquals(stadium.getEmail(), response.getEmail());
    }

    public void testMapScopeIdsToScopeEntities() {

    }

    public void testMapScopeEntitiesToStringScopes() {
    }
}
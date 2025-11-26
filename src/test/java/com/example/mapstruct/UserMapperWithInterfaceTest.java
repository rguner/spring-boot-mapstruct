package com.example.mapstruct;

import com.example.mapstruct.domain.UserEntity;
import com.example.mapstruct.dto.UserDto;
import com.example.mapstruct.mapper.UserMapperWithInterface;
import com.example.mapstruct.service.CalcService;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class UserMapperWithInterfaceTest {

    private final UserMapperWithInterface userMapperWithInterface = Mappers.getMapper(UserMapperWithInterface.class);

    @Test
    void testMapping() {
        UserEntity e = new UserEntity();
        CalcService calcService = new CalcService();
        e.setId(1L);
        e.setFirstName("Ada");
        e.setLastName("Lovelace");
        e.setEmail("ada@example.com");
        e.setActive(true);
        UserDto dto = userMapperWithInterface.toDto(e, calcService);
        assertEquals("Ada Lovelace", dto.getFullName());
        assertEquals(e.getEmail(), dto.getEmail());
        assertTrue(dto.isActive());
    }
}

package com.example.mapstruct.mapper;

import com.example.mapstruct.domain.UserEntity;
import com.example.mapstruct.dto.UserDto;
import com.example.mapstruct.service.CalcService;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-26T18:29:01+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class UserMapperWithInterfaceImpl implements UserMapperWithInterface {

    @Override
    public UserDto toDto(UserEntity entity, CalcService calcService) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setFullName( mapFullName( entity ) );
        userDto.setAge( calculateAge( calcService, entity ) );
        userDto.setEmail( entity.getEmail() );
        userDto.setId( entity.getId() );
        userDto.setActive( entity.isActive() );

        return userDto;
    }
}

package com.example.mapstruct.mapper;

import com.example.mapstruct.domain.UserEntity;
import com.example.mapstruct.dto.UserDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-26T18:28:54+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class UserMapperWithAbstractImpl extends UserMapperWithAbstract {

    @Override
    public UserDto toDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setFullName( mapFullName( entity ) );
        userDto.setAge( calculateAge( entity ) );
        userDto.setEmail( entity.getEmail() );
        userDto.setId( entity.getId() );
        userDto.setActive( entity.isActive() );

        return userDto;
    }
}

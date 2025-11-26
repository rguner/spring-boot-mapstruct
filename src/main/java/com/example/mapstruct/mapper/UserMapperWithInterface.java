package com.example.mapstruct.mapper;

import com.example.mapstruct.domain.UserEntity;
import com.example.mapstruct.dto.UserDto;
import com.example.mapstruct.service.CalcService;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapperWithInterface {

    @Mapping(target = "fullName", source = "entity", qualifiedByName = "nameMapper")
    @Mapping(target = "age", source = "entity", qualifiedByName = "calculateAge")
    UserDto toDto(UserEntity entity, @Context CalcService calcService);

    @Named("nameMapper")
    default String mapFullName(UserEntity e) {
        if (e == null) return null;
        return (e.getFirstName() + " " + e.getLastName()).trim();
    }

    @Named("calculateAge")
    default Integer calculateAge(@Context CalcService calcService,
                                 UserEntity e) {
        return calcService.calAgeFromName(e.getFirstName());
    }
}

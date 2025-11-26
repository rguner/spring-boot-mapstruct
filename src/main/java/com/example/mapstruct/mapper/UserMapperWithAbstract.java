package com.example.mapstruct.mapper;

import com.example.mapstruct.domain.UserEntity;
import com.example.mapstruct.dto.UserDto;
import com.example.mapstruct.service.CalcService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class UserMapperWithAbstract {

    @Autowired
    protected CalcService calcService;

    @Mapping(target = "fullName", source = ".", qualifiedByName = "nameMapper")
    @Mapping(target = "age", source = ".", qualifiedByName = "calculateAge")
    public abstract UserDto toDto(UserEntity entity);

    @Named("nameMapper")
    protected String mapFullName(UserEntity e) {
        if (e == null) return null;
        return (e.getFirstName() + " " + e.getLastName()).trim();
    }

    @Named("calculateAge")
    protected Integer calculateAge(UserEntity e) {
        if (e == null) return null;
        return calcService.calAgeFromName(e.getFirstName());
    }
}
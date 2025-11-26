package com.example.mapstruct.controller;

import com.example.mapstruct.domain.UserEntity;
import com.example.mapstruct.dto.UserDto;
import com.example.mapstruct.mapper.UserMapperWithInterface;
import com.example.mapstruct.mapper.UserMapperWithAbstract;
import com.example.mapstruct.service.CalcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserMapperWithInterface userMapperWithInterface;
    private final UserMapperWithAbstract userMapperWithAbstract;
    private final CalcService calcService;
    private final AtomicLong seq = new AtomicLong(1);

    public UserController(UserMapperWithInterface userMapperWithInterface,
                          UserMapperWithAbstract userMapperWithAbstract,
                          CalcService calcService) {
        this.userMapperWithInterface = userMapperWithInterface;
        this.userMapperWithAbstract = userMapperWithAbstract;
        this.calcService = calcService;
    }

    @GetMapping
    public List<UserDto> list() {
        UserEntity u1 = sample("Ada", "Lovelace", "ada@example.com", true);
        UserEntity u2 = sample("Grace", "Hopper", "grace@example.com", false);
        return List.of(userMapperWithInterface.toDto(u1, calcService),
                userMapperWithInterface.toDto(u2, calcService),
                userMapperWithAbstract.toDto(u1),
                userMapperWithAbstract.toDto(u2));
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserEntity entity) {
        if (entity.getId() == null) entity.setId(seq.getAndIncrement());
        return ResponseEntity.ok(userMapperWithInterface.toDto(entity, calcService));
    }

    private UserEntity sample(String fn, String ln, String email, boolean active) {
        UserEntity e = new UserEntity();
        e.setId(seq.getAndIncrement());
        e.setFirstName(fn);
        e.setLastName(ln);
        e.setEmail(email);
        e.setActive(active);
        return e;
    }
}

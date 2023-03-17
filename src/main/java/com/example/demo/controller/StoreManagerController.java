package com.example.demo.controller;

import com.example.demo.controller.dto.UserDto;
import com.example.demo.controller.mapper.UserMapper;
import com.example.demo.service.StoreService;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/manager")
public class StoreManagerController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final StoreService storeService;

    public StoreManagerController(UserService userService, UserMapper userMapper, StoreService storeService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.storeService = storeService;
    }

    @PostMapping("/employee")
    public ResponseEntity<UserDto> addEmployee(@RequestBody @Valid UserDto dto) {
        var user = userMapper.mapToEntity(dto);
        userService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(user.getId());
        return ResponseEntity.created(location).build();
    }


    @GetMapping("/employee/{id}")
    public ResponseEntity<UserDto> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(userMapper.mapToDto(userService.findById(id)));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/store/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}

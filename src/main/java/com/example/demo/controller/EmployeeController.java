package com.example.demo.controller;

import com.example.demo.controller.dto.CustomPageDto;
import com.example.demo.controller.dto.UserDto;
import com.example.demo.controller.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final UserService userService;
    private final UserMapper userMapper;

    public EmployeeController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployees(Pageable pageable) {
        var users = userService.findAllUsers(pageable)
                .map(userMapper::mapToDto);
        var customPage = new CustomPageDto<UserDto>(users.getContent(), pageable.getPageNumber(), pageable.getPageSize(), users.getTotalPages());
        return ResponseEntity.ok(customPage);
    }
}

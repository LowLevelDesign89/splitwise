package com.app.splitwise.controller;

import com.app.splitwise.models.dto.UserCreationDTO;
import com.app.splitwise.models.dto.UserResponseDTO;
import com.app.splitwise.models.entity.User;
import com.app.splitwise.models.mappers.UserDTOEntityMapper;
import com.app.splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreationDTO userCreationDTO) {
        User user = userService.createUser(userCreationDTO);
        return new ResponseEntity<>(UserDTOEntityMapper.toUserResponseDTO(user), HttpStatus.CREATED);
    }

}

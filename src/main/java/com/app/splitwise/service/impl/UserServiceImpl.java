package com.app.splitwise.service.impl;

import com.app.splitwise.models.dto.UserCreationDTO;
import com.app.splitwise.models.entity.User;
import com.app.splitwise.models.mappers.UserDTOEntityMapper;
import com.app.splitwise.repository.UserRepository;
import com.app.splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserCreationDTO userCreationDTO) {
        User user = UserDTOEntityMapper.toUser(userCreationDTO);
        // hash the password

        userRepository.save(user);
        return user;
    }
}

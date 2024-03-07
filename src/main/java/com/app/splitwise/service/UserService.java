package com.app.splitwise.service;

import com.app.splitwise.models.dto.UserCreationDTO;
import com.app.splitwise.models.entity.User;

public interface UserService {
    User createUser(UserCreationDTO userCreationDTO);
}

package com.app.splitwise.models.mappers;

import com.app.splitwise.models.dto.UserCreationDTO;
import com.app.splitwise.models.dto.UserResponseDTO;
import com.app.splitwise.models.entity.User;
import org.springframework.beans.BeanUtils;

public class UserDTOEntityMapper {
    public static UserResponseDTO toUserResponseDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        BeanUtils.copyProperties(user, userResponseDTO);
        return userResponseDTO;
    }

    public static User toUser(UserCreationDTO userCreationDTO) {
        User user = new User();
        BeanUtils.copyProperties(userCreationDTO, user);
        return user;
    }
}

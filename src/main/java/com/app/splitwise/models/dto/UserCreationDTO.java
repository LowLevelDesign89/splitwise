package com.app.splitwise.models.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserCreationDTO {
    @NotNull
    private String name;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String hashedPassword;
}

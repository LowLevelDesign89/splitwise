package com.app.splitwise.models.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "users")
@Data
public class User extends BaseModel {
    private String name;
    private String phoneNumber;
    private String hashedPassword;
}

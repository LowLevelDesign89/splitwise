package com.app.splitwise.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "groupss")
@Data
public class Group extends BaseModel {
    private String name;

    @ManyToMany
    private List<User> admins = new ArrayList<>();

    @ManyToMany
    private List<User> members = new ArrayList<>();

    @ManyToOne
    private User createdBy;
}

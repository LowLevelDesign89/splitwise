package com.app.splitwise.models.entity;

import com.app.splitwise.models.enums.Currency;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Entity
@Data
public class Expense extends BaseModel {
    private String description;
    private Double amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @ManyToOne
    private User createdBy;

    @ManyToMany
    private List<User> users = new ArrayList<>();

    @ElementCollection
    private Map<User, Double> paidBy = new HashMap<>();

    @ElementCollection
    private Map<User, Double> owedBy = new HashMap<>();
}

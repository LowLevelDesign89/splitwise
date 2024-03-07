package com.app.splitwise.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class GroupExpense extends BaseModel {
    @ManyToOne
    private Group group;

    @OneToOne
    private Expense expense;
}

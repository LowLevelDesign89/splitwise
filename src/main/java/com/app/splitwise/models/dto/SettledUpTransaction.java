package com.app.splitwise.models.dto;

import com.app.splitwise.models.entity.User;
import lombok.Data;

@Data
public class SettledUpTransaction {
    private Long from;
    private Long to;
    private Double amount;
}

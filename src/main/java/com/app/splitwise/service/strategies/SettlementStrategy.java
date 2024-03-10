package com.app.splitwise.service.strategies;

import com.app.splitwise.models.dto.SettledUpTransaction;
import com.app.splitwise.models.entity.Expense;

import java.util.List;

public interface SettlementStrategy {
    List<SettledUpTransaction> settleExpenses(List<Expense> expenses);
}

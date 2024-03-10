package com.app.splitwise.service.strategies.impl;

import com.app.splitwise.models.dto.SettledUpTransaction;
import com.app.splitwise.models.entity.Expense;
import com.app.splitwise.models.entity.User;
import com.app.splitwise.service.strategies.SettlementStrategy;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GreedySettlementStrategy implements SettlementStrategy {
    @Override
    public List<SettledUpTransaction> settleExpenses(List<Expense> expenses) {
        // step -1 - compute the balances
        Map<Long, Double> balances = computeBalances(expenses);

        // step - 1.5 - create treeset
        TreeSet<Pair<Long, Double>> expenseTree = new TreeSet<>((left, right)
                -> (int)(left.getSecond() - right.getSecond()));
        for(Map.Entry<Long, Double> entry: balances.entrySet()) {
            expenseTree.add(Pair.of(entry.getKey(), entry.getValue()));
        }

        List<SettledUpTransaction> transactions = new ArrayList<>();
        // step - 2 - iterate over the balances
        while(expenseTree.size() > 1) {
            // step -3 - Pick the max and min
            Pair<Long, Double> min = expenseTree.first();
            Pair<Long, Double> max = expenseTree.last();

            SettledUpTransaction settledUpTransaction = new SettledUpTransaction();
            settledUpTransaction.setFrom(max.getFirst());
            settledUpTransaction.setTo(min.getFirst());
            settledUpTransaction.setAmount(max.getSecond());

            expenseTree.remove(min);
            expenseTree.remove(max);

            expenseTree.add(Pair.of(min.getFirst(), min.getSecond() + max.getSecond()));
            transactions.add(settledUpTransaction);
        }
        //step - 4 - Update the existing balances and add a new transaction
        return transactions;
    }

    private Map<Long, Double> computeBalances(List<Expense> expenses) {
        // iterate over expenses
        // in the expense what is owed by and paid by
        // update the balances
        Map<Long, Double> balances = new HashMap<>();
        for(Expense expense: expenses) {
            // check the owedby
            for(Map.Entry<User, Double> entry: expense.getOwedBy().entrySet()) {
                User user = entry.getKey();
                Double amount = entry.getValue();
                if(!balances.containsKey(user.getId())) {
                    balances.put(user.getId(), 0.0);
                }
                balances.put(user.getId(), balances.getOrDefault(user.getId(), 0.0) + amount);
            }

            for(Map.Entry<User, Double> entry: expense.getPaidBy().entrySet()) {
                User user = entry.getKey();
                Double amount = entry.getValue();
                if(!balances.containsKey(user.getId())) {
                    balances.put(user.getId(), 0.0);
                }
                balances.put(user.getId(), balances.getOrDefault(user.getId(), 0.0) - amount);
            }
        }

        return balances;
    }
}

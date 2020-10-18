package com.tja.transaction.manager.model;

import java.util.ArrayList;
import java.util.List;

public class TransactionReadResults {

    private final List<Transaction> transactions;
    private final List<String> linesInError;

    public TransactionReadResults() {
        transactions = new ArrayList<>();
        linesInError = new ArrayList<>();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<String> getLinesInError() {
        return linesInError;
    }

    @Override
    public String toString() {
        return "TransactionReadResults{" +
                "transactions=" + transactions +
                ", linesInError=" + linesInError +
                '}';
    }
}

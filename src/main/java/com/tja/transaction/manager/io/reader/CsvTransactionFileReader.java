package com.tja.transaction.manager.io.reader;

import com.tja.transaction.manager.model.TransactionReadResults;

public class CsvTransactionFileReader implements TransactionFileReader{

    private final String fileName;

    CsvTransactionFileReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public TransactionReadResults readTransactions() {
        System.out.println("I am reading .csv files: " + fileName);
        return new TransactionReadResults();
    }
}

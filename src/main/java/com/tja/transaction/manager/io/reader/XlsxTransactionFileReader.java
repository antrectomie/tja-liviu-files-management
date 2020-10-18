package com.tja.transaction.manager.io.reader;

import com.tja.transaction.manager.model.TransactionReadResults;

public class XlsxTransactionFileReader implements TransactionFileReader{

    private final String fileName;

    protected XlsxTransactionFileReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public TransactionReadResults readTransactions() {
        System.out.println("I am reading .xlsx files: " + fileName);
        return new TransactionReadResults();
    }
}

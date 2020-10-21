package com.tja.transaction.manager.io.reader;

import com.tja.transaction.manager.model.TransactionReadResults;

import java.nio.file.Path;

public class CsvTransactionFileReader extends TransactionAbstractFileReader{


    CsvTransactionFileReader(String fileName) {
        super(fileName);
    }

    @Override
    protected TransactionReadResults readTransactions(Path filePath) throws Exception {
        System.out.println("todo impleent");
        return new TransactionReadResults();
    }
}

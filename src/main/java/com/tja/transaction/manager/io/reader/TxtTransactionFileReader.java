package com.tja.transaction.manager.io.reader;

import com.tja.transaction.manager.model.Transaction;
import com.tja.transaction.manager.model.TransactionReadResults;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static com.tja.transaction.manager.config.AppConfig.getConfigInstance;
import static com.tja.transaction.manager.util.TransactionMapper.mapTransactionStringToObject;

public class TxtTransactionFileReader extends TransactionAbstractFileReader {


    TxtTransactionFileReader(String fileName) {
        super(fileName);
    }


    @Override
    protected TransactionReadResults readTransactions(Path filePath) throws Exception {
        TransactionReadResults transactionReadResults = new TransactionReadResults();
        List<String> txLines = Files.readAllLines(filePath);
        for (String txLine : txLines) {
            readTransaction(transactionReadResults, txLine);
        }
        return transactionReadResults;
    }


    private void readTransaction(TransactionReadResults transactionReadResults, String txLine) {
        try {
            Transaction transaction = mapTransactionStringToObject(txLine, getConfigInstance().getTransactionSeparatorTxt());
            transactionReadResults.getTransactions().add(transaction);
        } catch (RuntimeException e) {
            transactionReadResults.getLinesInError().add(txLine);
        }
    }

}

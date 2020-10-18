package com.tja.transaction.manager.io.reader;

import com.tja.transaction.manager.model.Transaction;
import com.tja.transaction.manager.model.TransactionReadResults;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.tja.transaction.manager.config.AppConfig.getConfigInstance;
import static com.tja.transaction.manager.util.FileUtils.moveFileAfterRead;
import static com.tja.transaction.manager.util.TransactionMapper.mapTransactionStringToObject;

public class TxtTransactionFileReader implements TransactionFileReader {

    private final String fileName;

    TxtTransactionFileReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public TransactionReadResults readTransactions() {
        TransactionReadResults transactionReadResults = new TransactionReadResults();
        String transactionInputDir = getConfigInstance().getTransactionInputDir();
        Path filePath = Paths.get(transactionInputDir).resolve(fileName);
        try {
            List<String> txLines = Files.readAllLines(filePath);
            for (String txLine : txLines) {
                readTransaction(transactionReadResults, txLine);
            }
            moveFileAfterRead(filePath, false);
        } catch (Exception e) {
            moveFileAfterRead(filePath, true);
            e.printStackTrace();
        }

        return transactionReadResults;
    }

    private void readTransaction(TransactionReadResults transactionReadResults, String txLine) {
        try {
            Transaction transaction = mapTransactionStringToObject(txLine, getConfigInstance().getTransactionSeparatorTxt());
            transactionReadResults.getTransactions().add(transaction);
        } catch (RuntimeException e) {
            transactionReadResults.getLinesInError().add(txLine);
            throw e;
        }
    }

}

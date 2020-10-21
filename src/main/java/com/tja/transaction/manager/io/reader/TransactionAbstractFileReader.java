package com.tja.transaction.manager.io.reader;

import com.tja.transaction.manager.model.TransactionReadResults;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.tja.transaction.manager.config.AppConfig.getConfigInstance;
import static com.tja.transaction.manager.util.FileUtils.moveFileAfterRead;

public abstract class TransactionAbstractFileReader implements TransactionFileReader {

    private final String fileName;

    TransactionAbstractFileReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public TransactionReadResults readTransactions() {
        String transactionInputDir = getConfigInstance().getTransactionInputDir();
        Path filePath = Paths.get(transactionInputDir).resolve(fileName);
        try {
            //poate fi orice cod
            TransactionReadResults transactionReadResults = readTransactions(filePath);
            // do not move the file if has transaction in error
            if (transactionReadResults.getLinesInError().isEmpty()) {
                moveFileAfterRead(filePath, false);
            }
            return transactionReadResults;
        } catch (Exception e) {
            moveFileAfterRead(filePath, true);
            e.printStackTrace();
        }

        return new TransactionReadResults();
    }

    protected abstract TransactionReadResults readTransactions(Path filePath) throws Exception;
}

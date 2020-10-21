package com.tja.transaction.manager;

import com.tja.transaction.manager.config.AppConfig;
import com.tja.transaction.manager.io.reader.TransactionFileReader;
import com.tja.transaction.manager.io.reader.TransactionFileReaderFactory;
import com.tja.transaction.manager.model.TransactionReadResults;
import com.tja.transaction.manager.util.FileUtils;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        System.out.println("hello maven project");

        AppConfig appConfig = AppConfig.getConfigInstance();
        System.out.println(appConfig.getTransactionErrorDir());
        System.out.println(appConfig.getTransactionInputDir());
        System.out.println(appConfig.getTransactionOutputDir());
        System.out.println(appConfig.getTransactionProcessedDir());

        String transactionInputDir = appConfig.getTransactionInputDir();
        File input = new File(transactionInputDir);
        File[] files = input.listFiles();

        for (File file : files) {
            TransactionFileReader transactionFileReader = TransactionFileReaderFactory.createTransactionFileReader(file.getName());
            TransactionReadResults transactionReadResults = transactionFileReader.readTransactions();
            System.out.println(transactionReadResults);
            if (!transactionReadResults.getLinesInError().isEmpty()) {
                FileUtils.moveFileAfterRead(file.toPath(), true);
            }
        }

    }


}

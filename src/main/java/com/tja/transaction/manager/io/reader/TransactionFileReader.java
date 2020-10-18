package com.tja.transaction.manager.io.reader;

import com.tja.transaction.manager.model.TransactionReadResults;

public interface TransactionFileReader {

    TransactionReadResults readTransactions();

}

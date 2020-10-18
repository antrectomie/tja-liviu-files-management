package com.tja.transaction.manager.util;

import com.tja.transaction.manager.model.Transaction;

public interface TransactionMapper {

    static Transaction mapTransactionStringToObject(String txLine, String separator) {
        String[] elements = txLine.split(separator);
        return Transaction.newBuilder()
                .id(Long.parseLong(elements[0]))
                .fromIban(elements[1])
                .toIban(elements[2])
                .amount(Double.parseDouble(elements[3].replace(",", ".")))
                .fromBank(elements[4])
                .toBank(elements[4])
                .build();

    }
}

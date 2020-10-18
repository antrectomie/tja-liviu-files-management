package com.tja.transaction.manager.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.tja.transaction.manager.config.AppConfig.getConfigInstance;

public interface FileUtils {

    static void moveFileAfterRead(Path filePath, boolean isInError) {
        try {
            String transactionMoveFolder = isInError ? getConfigInstance().getTransactionErrorDir() :
                    getConfigInstance().getTransactionProcessedDir();
            Path moveFolderPath = Paths.get(transactionMoveFolder);
            if (!Files.exists(moveFolderPath)) {
                Files.createDirectory(moveFolderPath);
            }
            Path moveFilepath = moveFolderPath.resolve(filePath.getFileName());
            Files.move(filePath, moveFilepath);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}

package com.tja.transaction.manager;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExcelIOExample {


    public static void main(String[] args) {

        //WRITE excel
        Path catsPath = Paths.get("cats.xlsx");
        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet catSheet = workbook.createSheet("cats");

            for (int i = 0; i < 10; i++) {
                Row row = catSheet.createRow(i);
                for (int j = 0; j < 3; j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue("cat " + i + " " + j);
                }
            }

            workbook.write(Files.newOutputStream(catsPath));

        } catch (IOException e) {
            System.out.println("OOOPS");
        }


        //READ excel
        try (Workbook workbook = new XSSFWorkbook(Files.newInputStream(catsPath))) {
            Sheet catSheet = workbook.getSheetAt(0);
            for (Row row : catSheet) {
                String rowLine = "";
                for (Cell cell : row) {
                    CellType cellType = cell.getCellType();
                    switch (cellType) {
                        case STRING:
                            rowLine += cell.getStringCellValue();
                            break;
                        case BLANK:
                            break;
                        case NUMERIC:
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    rowLine += "  ";
                }
                System.out.println(rowLine);
            }
        } catch (IOException e) {
            System.out.println("OPPS la citire");
        }


    }


}

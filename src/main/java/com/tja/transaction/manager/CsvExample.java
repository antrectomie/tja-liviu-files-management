package com.tja.transaction.manager;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvExample {



    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        System.out.println("Start");

        Path path = Paths.get("cats.csv");


        List<Animal> animals;
        try (BufferedReader reader = Files.newBufferedReader(path)) {

            CsvToBeanBuilder<Animal> animalCsvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            CsvToBean<Animal> csvToBean = animalCsvToBeanBuilder
                    .withType(Animal.class)
                    .build();
            animals = csvToBean.parse();
            System.out.println(animals);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("bla.csv"))) {
            StatefulBeanToCsv<Animal> statefulBeanToCsv = new StatefulBeanToCsvBuilder<Animal>(writer)
                    .withSeparator(';')
                    .build();
            statefulBeanToCsv.write(animals);
        }

    }


}

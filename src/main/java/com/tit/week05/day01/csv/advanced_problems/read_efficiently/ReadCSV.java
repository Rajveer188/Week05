package com.tit.week05.day01.csv.advanced_problems.read_efficiently;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

import static java.lang.System.out;

public class ReadCSV {
    // method to read large csv file in chunks of 100 lines and display count of records processed
    private static void readCsvInChunks(String filePath) {
        int chunkSize = 100;
        int processedCount = 0;
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            boolean isHeader = true;
            while (true) {
                int count = 0;
                // process only 100 lines at a time
                while (count < chunkSize && (row = reader.readNext()) != null) {
                    if (isHeader) {
                        out.println(String.join(", ", row));
                        isHeader = false;
                        continue;
                    }
                    count++;
                    processedCount++;
                    out.println(String.join(", ", row));
                }
                if (count == 0) {
                    break;
                } else {
                    out.println("\nprocessed " + processedCount + " records till now\n");
                }
            }
            out.println("\ntotal records processed- " + processedCount+"\n");
        } catch (IOException | CsvValidationException e) {
            out.println("exception while reading csv file- " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // define file path for large csv file
        String filePath = "d:\\com\\capgemini_training\\csv-data-handling\\src\\main\\resources\\LargeData.csv";
        // read csv file in chunks and display count of records
        readCsvInChunks(filePath);
    }
}

package com.tit.week05.day02.json.censor_analyzer;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.System.out;

public class CsvCensor {
    private static String censorTeam(String teamName) {
        int spaceIndex = teamName.indexOf(" ");
        return (spaceIndex != -1) ? teamName.substring(0, spaceIndex) + " ***" : teamName;
    }
    //method to censor csv file
    public static void censorCsvFile(String inputFile, String outputFile) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            String[] headers = reader.readNext();  //read headers
            if (headers == null) return;

            writer.writeNext(headers);  //write headers to output file

            String[] row;
            while ((row = reader.readNext()) != null) {
                if (row.length < 7) {
                    continue;
                }
                row[1] = censorTeam(row[1]);
                row[2] = censorTeam(row[2]);
                row[5] = censorTeam(row[5]);
                row[6] = "REDACTED";

                writer.writeNext(row);
            }
            out.println("Censored CSV file created");

        } catch (IOException e) {
            out.println("exception - " + e.getMessage());
        } catch (CsvValidationException e) {
            out.println("csv data not valid");
        }
    }
}

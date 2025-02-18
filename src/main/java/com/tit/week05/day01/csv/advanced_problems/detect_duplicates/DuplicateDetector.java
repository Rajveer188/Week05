package com.tit.week05.day01.csv.advanced_problems.detect_duplicates;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class DuplicateDetector {
    // method to detect and print duplicate records
    private static void detectDuplicates(Map<String, List<String>> recordMap) {
        out.println("duplicate records:");
        boolean hasDuplicates = false;
        for (Map.Entry<String, List<String>> entry : recordMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                hasDuplicates = true;
                for (String record : entry.getValue()) {
                    //print duplicate
                    out.println(record);
                    if(true){
                        break;
                    }
                }
            }
        }
        if (!hasDuplicates) {
            out.println("no duplicates found.");
        }
    }
    public static void main(String[] args) {
        // define file path
        String filePath = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\Data.csv";
        //map to store recods
        Map<String, List<String>> map = new HashMap<>();

        // create a csv reader to read data
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            // array to store data
            String[] employee;
            boolean isHeader = true;
            while ((employee = csvReader.readNext()) != null) {
                // skip header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                // store records based on id using if else
                if (map.containsKey(employee[0])) {
                    map.get(employee[0]).add(String.join(",", employee));
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(String.join(",", employee));
                    map.put(employee[0], list);
                }
            }
            detectDuplicates(map);
        } catch (FileNotFoundException e) {
            out.println("file not found");
        } catch (IOException e) {
            out.println("exception while reading file");
        } catch (CsvValidationException e) {
            out.println("data not valid");
        }
    }
}

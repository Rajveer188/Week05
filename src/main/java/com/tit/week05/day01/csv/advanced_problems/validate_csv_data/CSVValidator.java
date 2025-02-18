package com.tit.week05.day01.csv.advanced_problems.validate_csv_data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.System.out;

public class CSVValidator {
    //method to validate data
    private static void validateData(String[] employee) {
        String emailRegex = "^[a-zA-Z0-9+_.%-]+@[a-zA-Z0-9_.-]+\\.[a-zA-Z]{2,}$";
        String numberRegex = "\\d{10}";
        //validate email
        if(!employee[1].trim().matches(emailRegex)){
            out.println(employee[0] + "'s email not valid - " + employee[1]);
        }
        //validate number
        if(!employee[2].matches(numberRegex)){
            out.println(employee[0] + "'s number not valid - " + employee[2]);
        }
    }
    public static void main(String[] args) {
        //define file path
        String filePath = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\Data.csv";
        //create a csv reader to read data
        try(CSVReader csvReader = new CSVReader(new FileReader(filePath))){
            //array to store data
            String[] employee;
            boolean isHeader = true;
            while ((employee = csvReader.readNext()) != null) {
                //skip header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                //validate data
                validateData(employee);
            }
        } catch (FileNotFoundException e) {
            out.println("file not found");
        } catch (IOException e) {
            out.println("exception while reading file");
        } catch (CsvValidationException e) {
            out.println("data not valid");
        }
    }
}

package com.tit.week05.day01.csv.intermediate_problems.modify_file;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.System.out;

public class CSVModifier{
    public static void main(String[] args) {
        //define file path
        String inputFile = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\employee.csv";
        String outputFile = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\ModifiedEmployee.csv";

        //create a csv reader to read data
        try(CSVReader csvReader = new CSVReader(new FileReader(inputFile));
            CSVWriter csvWriter = new CSVWriter(new FileWriter(outputFile))){
            //array to store data
            String[] employee;
            boolean isHeader = true;
            while ((employee = csvReader.readNext()) != null) {
                //skip header
                if (isHeader) {
                    isHeader = false;
                    csvWriter.writeNext(employee);
                    continue;
                }
                String employeedDepartment = employee[2].trim();
                if(employeedDepartment.equals("IT")){
                    //increment salary
                    double oldSalary = Double.parseDouble(employee[3]);
                    double newSalary = oldSalary + (oldSalary * 10 / 100);
                    employee[3] = String.valueOf(newSalary);
                }
                //write updated data
                csvWriter.writeNext(employee);
            }
            out.println("salary updated successfully");
        } catch (FileNotFoundException e) {
            out.println("file not found");
        } catch (IOException e) {
            out.println("exception while reading file");
        } catch (CsvValidationException e) {
            out.println("data not valid");
        }
    }
}

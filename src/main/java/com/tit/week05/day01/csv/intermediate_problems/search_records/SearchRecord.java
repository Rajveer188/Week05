package com.tit.week05.day01.csv.intermediate_problems.search_records;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.System.out;

public class SearchRecord{
    public static void main(String[] args) {
        //define file path
        String filePath = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\employee.csv";
        //define employee to search
        String employeeName = "Rajveer";
        //create a csv reader to read data
        try(CSVReader csvReader = new CSVReader(new FileReader(filePath))){
            //array to store data
            String[] data;
            boolean isHeader = true;
            boolean employeeFound = false;
            while ((data = csvReader.readNext()) != null){
                //skip header
                if(isHeader){
                    isHeader = false;
                    continue;
                }
                //search for employee
                if(employeeName.equals(data[1].trim())){
                    employeeFound = true;
                    out.println("employee name - " + employeeName +
                            "\ndepartment - " + data[2] +
                            "\nsalary - " + data[3]);
                    break;
                }
            }
            if(!employeeFound){
                out.println("no employee found");
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

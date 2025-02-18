package com.tit.week05.day01.csv.intermediate_problems.filter_records;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static java.lang.System.out;

public class FilterRecords {
    public static void main(String[] args) {
        //define file path
        String filePath = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\student.csv";
        //create a csv reader to read file
        try(CSVReader csvReader = new CSVReader(new FileReader(filePath))){
            //array to store data
            String[] data;
            boolean isHeader = true;
            while ((data = csvReader.readNext()) != null){
                //skip header
                if(isHeader){
                    isHeader = false;
                    continue;
                }
                //print line with marks greater than 80
                if(Integer.parseInt(data[3]) > 80){
                    out.println(Arrays.toString(data));
                }
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

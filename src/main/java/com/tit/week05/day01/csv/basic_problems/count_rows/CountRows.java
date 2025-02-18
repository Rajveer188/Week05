package com.tit.week05.day01.csv.basic_problems.count_rows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.System.out;

public class CountRows {
    public static void main(String[] args) {
        //define file path
        String filePath = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\student.csv";
        //create a file reader to read file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            //variable to track count
            int columnCount = 0;
            //variable to store data
            String line;
            while ((line = bufferedReader.readLine()) != null){
                columnCount++;
            }
            //excluding the header row
            columnCount = columnCount-1;
            out.println("total column - " + columnCount);
        } catch (IOException e) {
            out.println("exception while reading file");
        }
    }
}

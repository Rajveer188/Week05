package com.tit.week05.day01.csv.basic_problems.read_and_print;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.System.out;

public class ReadCSV {
    public static void main(String[] args) {
        //define file path
        String filePath = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\student.csv";
        //create a file reader to read file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            //variable to store data
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] columns = line.split(",");
                out.println(columns[0] + "\t" + columns[1] + "\t" + columns[2] + "\t" + columns[3]);
            }
        } catch (IOException e) {
            out.println("exception while reading file");
        }
    }
}

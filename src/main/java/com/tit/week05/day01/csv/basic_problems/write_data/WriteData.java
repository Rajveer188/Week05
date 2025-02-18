package com.tit.week05.day01.csv.basic_problems.write_data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.System.out;

public class WriteData{
    public static void main(String[] args) {
        //define file path
        String filePath = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\employee.csv";
        //create a file writer to write file
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            String header = "ID, Name, Department, Salary\n";
            String employee1 = "007, Aditya, IT, 77000\n";
            String employee2 = "088, Rajveer, Cloud, 85000\n";
            String employee3 = "034, Darshan, Cloud, 87000\n";
            String employee4 = "001, Adarsh, IT, 75000\n";
            String employee5 = "018, Ankit, HR, 74000\n";

            //write data
            bufferedWriter.write(header);
            bufferedWriter.write(employee1);
            bufferedWriter.write(employee2);
            bufferedWriter.write(employee3);
            bufferedWriter.write(employee4);
            bufferedWriter.write(employee5);

            out.println("file written successfully");
        } catch (IOException e) {
            out.println("exception while writing file");
        }
    }
}

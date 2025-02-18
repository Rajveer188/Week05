package com.tit.week05.day01.csv.intermediate_problems.sort_records;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

public class SortRecords {
    //method to read file
    private static List<String[]> readFile (String filePath){
        //list to store data
        List<String[]> list = new ArrayList<>();
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
                list.add(employee);
            }
        } catch (FileNotFoundException e) {
            out.println("file not found");
        } catch (IOException e) {
            out.println("exception while reading file");
        } catch (CsvValidationException e) {
            out.println("data not valid");
        }
        return list;
    }
    //method to sort and print top 5 employee
    private static void sortList(List<String[]> list) {
        //sort employees
        list.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(Double.parseDouble(o1[3]) > Double.parseDouble(o2[3])){
                    return -1;
                }else  if(Double.parseDouble(o1[3]) < Double.parseDouble(o2[3])){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        //print top 5 employees
        for(int i =0; i<5; i++){
            out.println(Arrays.toString(list.get(i)));
        }
    }
    public static void main(String[] args) {
        //define file path
        String filePath = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\employee.csv";
        //convert data to list
        List<String[]> list = readFile(filePath);
        //sort employee and print top 5
        sortList(list);
    }
}

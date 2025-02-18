package com.tit.week05.day01.csv.advanced_problems.csv_to_object;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

public class ParseCSV {
    //method to print students
    private static void printStudents(List<Student> studentList) {
        for(Student student : studentList){
            out.println(student.getId() + " " + student.getName() + " " + student.getAge() + " " + student.getMarks());
        }
    }
    public static void main(String[] args) {
        //define file path
        String filePath = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\student.csv";

        try (FileReader fileReader = new FileReader(filePath)){
             //create csvToBean
            CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(fileReader).withType(Student.class).withIgnoreLeadingWhiteSpace(true).build();

            //store objects to list
            List<Student> studentList = csvToBean.parse();
            //print object
            printStudents(studentList);
        } catch (FileNotFoundException e) {
            out.println("file not found");
        } catch (IOException e) {
            out.println("exception while reading file");
        }
    }
}

package com.tit.week05.day01.csv.advanced_problems.merge_csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class MergeCSV {
    public static void main(String[] args) {
        String students1Path = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\students1.csv";
        String students2Path = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\students2.csv";
        String mergedPath = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\ModifiedEmployee.csv";

        List<String[]> students1Data = new ArrayList<>();
        List<String[]> students2Data = new ArrayList<>();

        //read file 1
        try (CSVReader reader1 = new CSVReader(new FileReader(students1Path))) {
            students1Data = reader1.readAll();
        } catch (FileNotFoundException e) {
            out.println("file not found");
        } catch (IOException e) {
            out.println("exception while reading file");
        } catch (CsvException e) {
            out.println("csv exception");
        }
        //read file 2
        try (CSVReader reader2 = new CSVReader(new FileReader(students2Path))) {
            students2Data = reader2.readAll();
        } catch (FileNotFoundException e) {
            out.println("file not found");
        } catch (IOException e) {
            out.println("exception while reading file");
        }catch (CsvException e) {
            out.println("csv exception");
        }

        //merge and write data
        try (CSVWriter writer = new CSVWriter(new FileWriter(mergedPath))) {
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});

            for (int i = 1; i < students1Data.size(); i++) { // Skipping header row
                String[] student1 = students1Data.get(i);
                for (int j = 1; j < students2Data.size(); j++) {
                    String[] student2 = students2Data.get(j);
                    if (student1[0].equals(student2[0])) { // Compare ID
                        String[] mergedData = {student1[0], student1[1], student1[2], student2[1], student2[2]};
                        writer.writeNext(mergedData);
                        break;
                    }
                }
            }

            System.out.println("merged file created successfully");

        } catch (IOException e) {
            out.println("exception while writing file");
        }
    }
}

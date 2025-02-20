package com.tit.week05.day02.json.hands_on_problems.csv_to_json;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;

public class CsvToJsonConvertor {
    public static void main(String[] args) {
        //define file paths
        String csvFilePath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\CsvData.csv";
        String jsonFilePath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\JsonData.json";

        //create a csv reader
        try(CSVReader csvReader = new CSVReader(new FileReader(csvFilePath));
            FileWriter file = new FileWriter(jsonFilePath)) {
            String[] header = csvReader.readNext();

            JSONArray jsonArray = new JSONArray();
            String[] row;
            while ((row = csvReader.readNext()) != null){
                JSONObject jsonObject = new JSONObject();
                for (int i = 0; i < header.length; i++) {
                    //add key value
                    jsonObject.put(header[i], row[i]);
                }
                jsonArray.put(jsonObject);
            }
            file.write(jsonArray.toString(2));
            out.println("csv file converted to json");
        } catch (FileNotFoundException e) {
            out.println("file not found");
        } catch (IOException e) {
            out.println("exception while reading file");
        } catch (CsvValidationException e) {
            out.println("invalid csv data");
        }


    }
}

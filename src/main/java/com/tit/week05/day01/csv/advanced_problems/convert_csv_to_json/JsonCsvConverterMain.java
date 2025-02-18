package com.tit.week05.day01.csv.advanced_problems.convert_csv_to_json;

public class JsonCsvConverterMain {
    public static void main(String[] args) {
        //define file path
        String jsonFilePath = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\students.json";
        String csvFilePath = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\student.csv";
        String outputJsonFilePath = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\StudentOutput.json";
        String outputCsvFilePath = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\OutputCsvFilePath.json";

        // convert csv back to json
        CsvToJsonConverter.convert(csvFilePath, outputJsonFilePath);
        // convert json to csv
        JsonToCsvConverter.convert(jsonFilePath, outputCsvFilePath);
    }

}

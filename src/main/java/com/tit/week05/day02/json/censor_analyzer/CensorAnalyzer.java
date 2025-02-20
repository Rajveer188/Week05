package com.tit.week05.day02.json.censor_analyzer;

import static com.tit.week05.day02.json.censor_analyzer.CsvCensor.censorCsvFile;
import static com.tit.week05.day02.json.censor_analyzer.JsonCensor.censorJsonFile;

public class CensorAnalyzer {

    public static void main(String[] args) {
        //define file path
        String jsonInputFilePath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\ipl_data.json";
        String csvInputFilePath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\ipl_data.csv";
        String jsonOutputFilePath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\censored_ipl_data.json";
        String csvOutputFilePath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\censored_ipl_data.csv";

        //censor json file
        censorJsonFile(jsonInputFilePath, jsonOutputFilePath);
        //censor csv file
        censorCsvFile(csvInputFilePath, csvOutputFilePath);
    }
}

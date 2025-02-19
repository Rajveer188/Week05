package com.tit.week05.day02.json.practice_problems.validate_json_structure;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonValidator {
    private static boolean isValid(File jsonFile){
        try{
            ObjectMapper mapper = new ObjectMapper();

            JsonNode jsonNode = mapper.readTree(jsonFile);
            return true;
        }catch (IOException e) {
            return false;
        }
    }
    public static void main(String[] args) {
        //define file path
        String filePath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\person.json";
        File file = new File(filePath);
        //validate
        if (isValid(file)) {
            System.out.println("JSON file is valid");
        } else {
            System.out.println("invalid JSON file");
        }
    }
}

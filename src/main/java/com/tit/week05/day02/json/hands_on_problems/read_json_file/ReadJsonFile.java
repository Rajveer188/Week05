package com.tit.week05.day02.json.hands_on_problems.read_json_file;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static java.lang.System.out;

public class ReadJsonFile {
    public static void main(String[] args) {
        //define file path
        String filePath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\person.json";
        File file = new File(filePath);

        //create an object of object mapper
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(file);
            //get all field name
            Iterator<String> fieldNames = jsonNode.fieldNames();
            while (fieldNames.hasNext()){
                String key = fieldNames.next();
                out.println(key + " : " + jsonNode.get(key));
            }
        } catch (IOException e) {
            out.println("exception while reading file");
        }
    }
}

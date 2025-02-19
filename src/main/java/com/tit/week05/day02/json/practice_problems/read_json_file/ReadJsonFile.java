package com.tit.week05.day02.json.practice_problems.read_json_file;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import static java.lang.System.out;

public class ReadJsonFile {
    public static void main(String[] args) {
        //define file path
        String filePath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\person.json";
        //create an object mapper
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));
            //print specific values
            out.println("name - " + jsonNode.get("name").asText() +
                    "\nemail - " + jsonNode.get("email").asText());
        } catch (IOException e) {
            out.println("exception while reading file ");
        }

    }
}

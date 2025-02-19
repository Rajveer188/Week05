package com.tit.week05.day02.json.hands_on_problems.filter_json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import static java.lang.System.out;

public class FilterJson {
    public static void main(String[] args) {
        //define file path
        String filePath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\user.json";
        File file = new File(filePath);

        //create object of object mapper
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootJsonNode = objectMapper.readTree(file);
            for(JsonNode jsonNode : rootJsonNode){
                //check age
                if(jsonNode.get("age").asInt() > 25){
                    out.println(jsonNode);
                }
            }
        } catch (JsonProcessingException e) {
            out.println("exception while parsing json file" + e.getMessage());
        } catch (IOException e) {
            out.println("exception while reading file");
        }
    }
}

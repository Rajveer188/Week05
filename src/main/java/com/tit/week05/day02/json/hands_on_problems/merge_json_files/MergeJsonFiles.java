package com.tit.week05.day02.json.hands_on_problems.merge_json_files;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.management.ObjectName;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import static java.lang.System.out;

public class MergeJsonFiles {
    public static void main(String[] args) {
        //define file path
        String firstFilePath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\user1.json";
        String secondFilePath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\user2.json";
        String mergedFilePath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\mergedUser.json";

        //create an object mapper
        ObjectMapper objectMapper = new ObjectMapper();
        //create json node for file
        try {
            JsonNode firstJsonNode = objectMapper.readTree(new File(firstFilePath));
            JsonNode secondJsonNode = objectMapper.readTree(new File(secondFilePath));

            //objectnode to store data
            ObjectNode objectNode = objectMapper.createObjectNode();

            //add first file data
            Iterator<Map.Entry<String, JsonNode>> firstFileFields = firstJsonNode.fields();
            while (firstFileFields.hasNext()) {
                Map.Entry<String, JsonNode> entry = firstFileFields.next();
                objectNode.set(entry.getKey(), entry.getValue());
            }
            //add first file data
            Iterator<Map.Entry<String, JsonNode>> secondFileFields = secondJsonNode.fields();
            while (secondFileFields.hasNext()) {
                Map.Entry<String, JsonNode> entry = secondFileFields.next();
                objectNode.set(entry.getKey(), entry.getValue());
            }

            //write merged data to file
            objectMapper.writeValue(new File(mergedFilePath), objectNode);
            out.println("data merged successfully");
        } catch (JsonProcessingException e) {
            out.println("exception while processing json file" + e.getMessage());
        } catch (IOException e) {
            out.println("exception while writing json file");
        }
    }
}

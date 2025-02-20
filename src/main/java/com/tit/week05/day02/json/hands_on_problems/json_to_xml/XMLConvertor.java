package com.tit.week05.day02.json.hands_on_problems.json_to_xml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import static java.lang.System.out;

public class XMLConvertor {
    public static void main(String[] args) {
        //define file paths
        String jsonFilePath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\mergedUser.json";
        String xmlFilePath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\user.xml";

        //create object of object mapper
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //read json file
            JsonNode jsonNode = objectMapper.readTree(new File(jsonFilePath));

            //create object of xml mapper
            XmlMapper xmlMapper = new XmlMapper();
            //convert to xml
            xmlMapper.writeValue(new File(xmlFilePath), jsonNode);
            out.println("json converted to xml");
        } catch (IOException e) {
            out.println("exception while reading json file");
        }
    }

}

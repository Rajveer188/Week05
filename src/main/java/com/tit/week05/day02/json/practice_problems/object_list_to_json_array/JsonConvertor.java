package com.tit.week05.day02.json.practice_problems.object_list_to_json_array;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class JsonConvertor {
    public static void main(String[] args) {
        //create a list of student object
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Rajveer", 88));
        studentList.add(new Student("Darshan", 34));
        studentList.add(new Student("Adarsh", 1));

        //convert list to json array
        ObjectMapper objectMapper = new ObjectMapper();

       for(Student student : studentList){
            try {
                String jsonArray = objectMapper.writeValueAsString(student);
                out.println(jsonArray);
            } catch (JsonProcessingException e) {
                out.println("exception while parsing object" + e.getMessage());
            }
        }
    }
}

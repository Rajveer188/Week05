package com.tit.week05.day02.json.practice_problems.json_object;

import org.json.JSONArray;
import org.json.JSONObject;

import static java.lang.System.out;

public class StudentJsonObject {
    public static void main(String[] args) {
        //create a json object
        JSONObject studentJsonObject = new JSONObject();

        studentJsonObject.put("age", 20);
        studentJsonObject.put("Name", "Rajveer");

        //create subject array
        JSONArray subjects = new JSONArray();
        subjects.put("Data structure");
        subjects.put("OOP");
        subjects.put("Computer Network");

        //add array to json object
        studentJsonObject.put("Subjects" , subjects);

        //print json object
        out.println(studentJsonObject.toString(2));
    }
}

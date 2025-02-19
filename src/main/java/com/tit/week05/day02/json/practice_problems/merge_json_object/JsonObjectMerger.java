package com.tit.week05.day02.json.practice_problems.merge_json_object;

import org.json.JSONObject;

import static java.lang.System.out;

public class JsonObjectMerger {
    public static void main(String[] args) {
        //create two json object
        JSONObject fistJsonObject = new JSONObject();
        fistJsonObject.put("name" , "Rajveer Kajle");
        fistJsonObject.put("age", 19);

        JSONObject secondJsonObject = new JSONObject();
        secondJsonObject.put("skill", new String[]{"java","spring","database"});
        secondJsonObject.put("city","Bhopal");

        //json object to store merged json object
        JSONObject mergedJsonObject = new JSONObject();

        //store first object
        for(String key : fistJsonObject.keySet()){
            mergedJsonObject.put(key, fistJsonObject.get(key));
        }
        //store second object
        for(String key : secondJsonObject.keySet()){
            mergedJsonObject.put(key, secondJsonObject.get(key));
        }

        out.println(mergedJsonObject.toString(1));
    }
}

package com.tit.week05.day02.json.practice_problems.object_to_json;

import com.google.gson.Gson;

import static java.lang.System.out;

public class ObjectToJson {
    public static void main(String[] args) {
        //create an object of car
        Car car = new Car("XX01", "Petrol");

        //create a Gson object
        Gson gson = new Gson();
        //convert object to json
        String carJson = gson.toJson(car);
        //print result
        out.println(carJson);
        }
}

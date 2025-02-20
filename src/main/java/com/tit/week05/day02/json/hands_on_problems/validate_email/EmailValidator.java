package com.tit.week05.day02.json.hands_on_problems.validate_email;


import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import static java.lang.System.out;

public class EmailValidator {
    public static void main(String[] args) {
        String schemaPath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\schema.json";
        String jsonPath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\email.json";

        try {
            Schema schema = SchemaLoader.load(new JSONObject(new JSONTokener(new FileInputStream(schemaPath))));

            schema.validate(new JSONObject(new JSONTokener(new FileInputStream(jsonPath))));

            System.out.println("all emails are valid!");

        }catch (FileNotFoundException e) {
            out.println("file not found");
        }catch (ValidationException e) {
            out.println("some emails are not valid");
        }
    }
}

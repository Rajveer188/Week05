//package com.tit.week05.day02.json.hands_on_problems.json_report;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.FileWriter;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.ResultSet;
//
//import static java.lang.System.out;
//
//public class DBToJson {
//    public static void main(String[] args) {
//        //connect to database
//        String url = "jdbc:mysql://localhost:3306/rajveerDatabse"; // Change DB name
//        String user = "rajveer";  // Change username
//        String password = "veer@123"; // Change password
//        String jsonFilePath = "D:\\Com\\Capgemini_Training\\JSON\\src\\main\\resources\\report.json";
//
//        try (Connection connection = DriverManager.getConnection(url, user, password);
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery("SELECT id, name FROM user")) {
//
//            JSONArray jsonArray = new JSONArray();
//
//            while (resultSet.next()) {
//                JSONObject jsonObject = new JSONObject();
//                jsonObject.put("id", resultSet.getInt("id"));
//                jsonObject.put("name", resultSet.getString("name"));
//                jsonArray.put(jsonObject);
//            }
//
//            //write JSON to file
//            try (FileWriter file = new FileWriter(jsonFilePath)) {
//                file.write(jsonArray.toString(2));
//            }
//        } catch (SQLException | IOException e) {
//            out.println("exception " + e.getMessage());
//        }
//    }
//}

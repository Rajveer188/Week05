package com.tit.week05.day01.csv.advanced_problems.csv_report_from_database;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

import static java.lang.System.out;

public class DatabaseToCSV {
    public static void exportToCSV(String url, String user, String password, String filePath) {
        String query = "SELECT employee_id, name, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             FileWriter writer = new FileWriter(filePath)) {

            writer.write("Employee ID,Name,Department,Salary\n");
            while (rs.next()) {
                writer.write(rs.getInt("employee_id") + ","
                        + rs.getString("name") + ","
                        + rs.getDouble("salary") + "\n");
            }

            out.println("CSV file generated successfully: " + filePath);

        } catch (SQLException | IOException e) {
            out.println("exception - "+ e.getMessage());
        }
    }
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Rajveer";
        String user = "rajveer188";
        String password = "123456";
        String filePath = "D:\\Com\\Capgemini_Training\\CSV-Data-Handling\\src\\main\\resources\\Database.csv";

        exportToCSV(url, user, password, filePath);
    }
}
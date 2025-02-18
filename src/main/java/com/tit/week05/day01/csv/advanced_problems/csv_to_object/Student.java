package com.tit.week05.day01.csv.advanced_problems.csv_to_object;

public class Student {
    //attribute
    private String id;
    private String name;
    private int age;
    private double marks;

    //getter
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getMarks() {
        return marks;
    }
    //setter
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }
}

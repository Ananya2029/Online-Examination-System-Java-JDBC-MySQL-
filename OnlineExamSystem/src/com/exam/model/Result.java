package com.exam.model;

public class Result {

    private String name;
    private String phone;
    private int age;
    private int score;

    public Result(String name, String phone, int age, int score) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.score = score;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public int getAge() { return age; }
    public int getScore() { return score; }
}
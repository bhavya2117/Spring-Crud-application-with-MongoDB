package com.example.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class StudentModel {
    private int id;
    private String name;
    private String city;
    private String college;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public StudentModel() {

    }

    public StudentModel(int id, String name, String city, String college) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.college = college;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", college='" + college + '\'' +
                '}';
    }

}

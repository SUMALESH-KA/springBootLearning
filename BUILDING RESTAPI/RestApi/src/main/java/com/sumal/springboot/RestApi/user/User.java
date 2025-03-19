package com.sumal.springboot.RestApi.user;

import java.time.LocalDate;

public class User {  // Fix class name capitalization

    private int id;
    private String name;
    private LocalDate date;

    // Default constructor (important for serialization)
    public User() {}

    // Parameterized constructor
    public User(int id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    // Getter and Setter for date (using LocalDate, not Date)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {  // Fix type mismatch
        this.date = date;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}

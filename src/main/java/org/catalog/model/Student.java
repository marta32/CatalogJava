package org.catalog.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private LocalDate birthday;

    public Student(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public int getId() {
        return this.id;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
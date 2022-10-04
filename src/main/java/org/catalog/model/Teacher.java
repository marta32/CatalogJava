package org.catalog.model;

import java.time.LocalDate;

public class Teacher {
    private int id;
    private String name;
    private LocalDate birthday;

    public Teacher(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Teacher(int id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }


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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public String serialize() {
        return id + "," + name + "," + birthday + "\n";
    }

    public static Teacher deserialize(String serializedTeacher) {
        String[] s = serializedTeacher.split(",");
        int id = Integer.parseInt(s[0]);
        String name = s[1];
        LocalDate birthday = LocalDate.parse(s[2]);
        return new Teacher(id, name, birthday);
    }

}
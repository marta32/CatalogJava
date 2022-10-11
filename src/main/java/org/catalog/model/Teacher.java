package org.catalog.model;

import java.time.LocalDate;

public class Teacher {
    private int id;
    private String first_name;
    private String last_name;
    private LocalDate birthday;

    public Teacher(String first_name, String last_name, LocalDate birthday) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthday = birthday;
    }

    public Teacher(int id, String first_name, String last_name, LocalDate birthday) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthday = birthday;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", first name='" + first_name + ", last name='" + last_name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public String serialize() {
        return id + "," + first_name + ", " + last_name + "," + birthday + "\n";
    }

    public static Teacher deserialize(String serializedTeacher) {
        String[] s = serializedTeacher.split(",");
        int id = Integer.parseInt(s[0]);
        String first_name = s[1];
        String last_name = s[2];
        LocalDate birthday = LocalDate.parse(s[3]);
        return new Teacher(id, first_name,last_name, birthday);
    }
}
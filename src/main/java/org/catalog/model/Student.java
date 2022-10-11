package org.catalog.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String first_name;
    private String last_name;
    private LocalDate birthday;

    public Student(String first_name, String last_name, LocalDate birthday) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthday = birthday;
    }

    public Student(int id,String first_name, String last_name, LocalDate birthday) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthday = birthday;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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


    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", first name='" + first_name + ", last name='" + last_name + '\'' + ", birthday=" + birthday + '}';
    }

    public String serialize() {
        return id + "," + first_name + "," + last_name + "," + birthday + "\n";
    }

    public static Student deserialize(String serializedStudent) {
        String[] s = serializedStudent.split(",");
        int id = Integer.parseInt(s[0]);
        String f_name = s[1];
        String l_name = s[2];
        LocalDate birthday = LocalDate.parse(s[3]);
        return new Student(id, f_name, l_name, birthday);
    }
}
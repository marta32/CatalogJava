package org.catalog.model;

public class Subject {
    private int id;
    private String name;
    private int idTeacher;

    public Subject(String name, int idTeacher) {
        this.name = name;
        this.idTeacher = idTeacher;
    }

    public Subject(int id, String name, int idTeacher) {
        this.id = id;
        this.name = name;
        this.idTeacher = idTeacher;
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

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idTeacher=" + idTeacher +
                '}';
    }

    public String serialize() {
        return id + "," + name + "," + idTeacher+ "\n";
    }

    public static Subject deserialize (String serializedSubject) {
        String[] s = serializedSubject.split(",");
        int id = Integer.parseInt(s[0]);
        String name = s[1];
        int idt = Integer.parseInt(s[2]);
        return new Subject(id, name, idt);
    }
}
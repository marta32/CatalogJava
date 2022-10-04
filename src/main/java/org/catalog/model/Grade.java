package org.catalog.model;

import java.time.LocalDate;

public class Grade {
    private int id;
    private int idStudent;
    private int idSubject;
    private int mark;
    private LocalDate dateMark;

    public Grade(int idStudent, int idSubject, int mark, LocalDate dateMark) {
        this.idStudent = idStudent;
        this.idSubject = idSubject;
        this.mark = mark;
        this.dateMark = dateMark;
    }

    public Grade(int id, int idStudent, int idSubject, int mark, LocalDate dateMark) {
        this.id = id;
        this.idStudent = idStudent;
        this.idSubject = idSubject;
        this.mark = mark;
        this.dateMark = dateMark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public LocalDate getDateMark() {
        return dateMark;
    }

    public void setDateMark(LocalDate dateMark) {
        this.dateMark = dateMark;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", idStudent=" + idStudent +
                ", idSubject=" + idSubject +
                ", mark=" + mark +
                ", dateMark=" + dateMark +
                '}';
    }

    public String serialize() {
        return id + "," + idStudent + "," + idSubject + "," + mark + "," + dateMark + "\n";
    }

    public static Grade deserialize(String serializedGrade) {
        String[] s = serializedGrade.split(",");
        int id = Integer.parseInt(s[0]);
        int idStud = Integer.parseInt(s[1]);
        int idSub = Integer.parseInt(s[2]);
        int mark = Integer.parseInt(s[3]);
        LocalDate birthday = LocalDate.parse(s[4]);
        return new Grade(id, idStud, idSub, mark, birthday);
    }
}

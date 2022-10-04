package org.catalog.service;

import org.catalog.exceptions.InvalidNameException;
import org.catalog.exceptions.InvalidBirthdayException;
import org.catalog.model.Student;
import org.catalog.model.Teacher;

public class Validator {

    private static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }
    public static void validate(Student student) {
        if (student.getName() == null || student.getName().isEmpty()) {
            throw new InvalidNameException("Name can not be empty!");
        }
        if (!isAlpha(student.getName())) {
            throw new InvalidNameException("Name can not contain another characters than letters!");
        }
        if (student.getBirthday() == null) {
            throw new InvalidBirthdayException("Birthday can not be empty!");
        }
        if (student.getBirthday().getYear() < 1995) {
            throw new InvalidBirthdayException("Birthday can not be before 1995!");
        }
    }

    public static void validate(Teacher teacher) {
        if (teacher.getName() == null || teacher.getName().isEmpty()) {
            throw new InvalidNameException("Name can not be empty!");
        }
        if (!isAlpha(teacher.getName())) {
            throw new InvalidNameException("Name can not contain another characters than letters!");
        }
        if (teacher.getBirthday() == null) {
            throw new InvalidBirthdayException("Birthday can not be empty!");
        }
        if (teacher.getBirthday().getYear() < 1995) {
            throw new InvalidBirthdayException("Birthday can not be before 1995!");
        }
    }





}
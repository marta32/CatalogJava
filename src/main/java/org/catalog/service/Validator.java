package org.catalog.service;

import org.catalog.exceptions.InvalidNameException;
import org.catalog.exceptions.InvalidBirthdayException;
import org.catalog.model.Student;

public class Validator {

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

    private static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

}
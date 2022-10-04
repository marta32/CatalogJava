package org.catalog.validator;

import org.catalog.exceptions.InvalidDateException;
import org.catalog.exceptions.InvalidNameException;
import org.catalog.model.Student;

public class StudentValidator {
    private static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public void validate(Student student) {
        if (student.getName() == null || student.getName().isEmpty()) {
            throw new InvalidNameException("Name can not be empty!");
        }
        if (!isAlpha(student.getName())) {
            throw new InvalidNameException("Name can not contain another characters than letters!");
        }
        char c = student.getName().charAt(0);
        if (Character.isLowerCase(c)) {
            throw new InvalidNameException("Name must to begin with capital letter!");
        }
        if (student.getBirthday() == null) {
            throw new InvalidDateException("Birthday can not be empty!");
        }
        if (student.getBirthday().getYear() < 1995) {
            throw new InvalidDateException("Birthday can not be before 1995!");
        }
    }
}

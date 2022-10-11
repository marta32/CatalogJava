package org.catalog.validator;

import org.catalog.exceptions.InvalidDateException;
import org.catalog.exceptions.InvalidNameException;
import org.catalog.model.Student;

public class StudentValidator {
    private static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public void validate(Student student) {
        if (student.getFirst_name() == null || student.getFirst_name().isEmpty()) {
            throw new InvalidNameException("First name can not be empty!");
        }
        if (student.getLast_name() == null || student.getLast_name().isEmpty()) {
            throw new InvalidNameException("Last name can not be empty!");
        }
        if (!isAlpha(student.getFirst_name())) {
            throw new InvalidNameException("First name can not contain another characters than letters!");
        }
        if (!isAlpha(student.getLast_name())) {
            throw new InvalidNameException("Last name can not contain another characters than letters!");
        }
        char c1 = student.getFirst_name().charAt(0);
        if (Character.isLowerCase(c1)) {
            throw new InvalidNameException("First name must to begin with capital letter!");
        }
        char c2 = student.getLast_name().charAt(0);
        if (Character.isLowerCase(c2)) {
            throw new InvalidNameException("Last name must to begin with capital letter!");
        }
        if (student.getBirthday() == null) {
            throw new InvalidDateException("Birthday can not be empty!");
        }
        if (student.getBirthday().getYear() < 1995) {
            throw new InvalidDateException("Birthday can not be before 1995!");
        }
    }
}

package org.catalog.validator;

import org.catalog.exceptions.InvalidDateException;
import org.catalog.exceptions.InvalidNameException;
import org.catalog.model.Teacher;

public class TeacherValidator {
    private static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public void validate(Teacher teacher) {
        if (teacher.getFirst_name() == null || teacher.getFirst_name().isEmpty()) {
            throw new InvalidNameException("First name can not be empty!");
        }
        if (teacher.getLast_name() == null || teacher.getLast_name().isEmpty()) {
            throw new InvalidNameException("Last name can not be empty!");
        }
        if (!isAlpha(teacher.getFirst_name())) {
            throw new InvalidNameException("First name can not contain another characters than letters!");
        }
        if (!isAlpha(teacher.getLast_name())) {
            throw new InvalidNameException("Last name can not contain another characters than letters!");
        }
        char c1 = teacher.getFirst_name().charAt(0);
        if (Character.isLowerCase(c1)) {
            throw new InvalidNameException("First name must to begin with capital letter!");
        }
        char c2 = teacher.getLast_name().charAt(0);
        if (Character.isLowerCase(c2)) {
            throw new InvalidNameException("Last name must to begin with capital letter!");
        }
        if (teacher.getBirthday() == null) {
            throw new InvalidDateException("Birthday can not be empty!");
        }
        if (teacher.getBirthday().getYear() < 1950) {
            throw new InvalidDateException("Birthday can not be before 1995!");
        }
    }
}

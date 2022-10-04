package org.catalog.validator;

import org.catalog.exceptions.InvalidDateException;
import org.catalog.exceptions.InvalidNameException;
import org.catalog.model.Teacher;

public class TeacherValidator {
    private static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public void validate(Teacher teacher) {
        if (teacher.getName() == null || teacher.getName().isEmpty()) {
            throw new InvalidNameException("Name can not be empty!");
        }
        if (!isAlpha(teacher.getName())) {
            throw new InvalidNameException("Name can not contain another characters than letters!");
        }
        char c = teacher.getName().charAt(0);
        if (Character.isLowerCase(c)) {
            throw new InvalidNameException("Name must to begin with capital letter!");
        }
        if (teacher.getBirthday() == null) {
            throw new InvalidDateException("Birthday can not be empty!");
        }
        if (teacher.getBirthday().getYear() < 1995) {
            throw new InvalidDateException("Birthday can not be before 1995!");
        }
    }
}

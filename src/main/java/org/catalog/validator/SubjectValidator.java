package org.catalog.validator;

import org.catalog.exceptions.InvalidNameException;
import org.catalog.exceptions.InvalidTeacherIdException;
import org.catalog.model.Subject;
import org.catalog.model.Teacher;
import org.catalog.repository.TeacherRepository;

public class SubjectValidator {

    private final TeacherRepository repoTeacher;

    public SubjectValidator(TeacherRepository repoTeacher) {
        this.repoTeacher = repoTeacher;
    }

    private static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public void validate(Subject subject) {
        if (subject.getName() == null || subject.getName().isEmpty()) {
            throw new InvalidNameException("Name can not be empty!");
        }
        if (!isAlpha(subject.getName())) {
            throw new InvalidNameException("Name can not contain another characters than letters!");
        }
        char c = subject.getName().charAt(0);
        if (Character.isLowerCase(c)) {
            throw new InvalidNameException("Name must to begin with capital letter!");
        }
        if (repoTeacher.readById(subject.getIdTeacher()) == null) {
            throw new InvalidTeacherIdException("Teacher id is not found!");
        }
    }
}

package org.catalog.validator;

import org.catalog.exceptions.InvalidDateException;
import org.catalog.exceptions.InvalidMarkException;
import org.catalog.exceptions.InvalidStudentIdException;
import org.catalog.exceptions.InvalidSubjectIdException;
import org.catalog.model.Grade;
import org.catalog.repository.StudentRepository;
import org.catalog.repository.SubjectRepository;

import java.time.Month;

public class GradeValidator {
    private final StudentRepository repoStudents;
    private final SubjectRepository repoSubjects;

    public GradeValidator(StudentRepository repoStudents, SubjectRepository repoSubjects) {
        this.repoStudents = repoStudents;
        this.repoSubjects = repoSubjects;
    }

    public void validate(Grade grade) {
        if (grade.getDateMark() == null) {
            throw new InvalidDateException("Date can not be empty!");
        }

        if (grade.getMark() < 1 && grade.getMark() > 10) {
            throw new InvalidMarkException("Grades can be between 1 and 10!");
        }

        if (repoStudents.readById(grade.getIdStudent()) == null) {
            throw new InvalidStudentIdException("Student id is not found!");
        }

        if (repoSubjects.readById(grade.getIdSubject()) == null) {
            throw new InvalidSubjectIdException("Subject id is not found!");
        }

        if (grade.getDateMark().getMonth().equals(Month.JULY) || grade.getDateMark().getMonth().equals(Month.AUGUST)) {
            throw new InvalidDateException("Can not add a grade in july and august!");
        }

    }
}

package org.catalog.service;

import org.catalog.model.Grade;
import org.catalog.repository.GradeRepository;
import org.catalog.repository.StudentRepository;
import org.catalog.repository.SubjectRepository;
import org.catalog.validator.GradeValidator;

import java.time.LocalDate;

public class GradeService {

    private final GradeRepository repo;
    private final GradeValidator validator;

    public GradeService(GradeRepository repo, StudentRepository studentRepo, SubjectRepository subjectRepo) {
        this.repo = repo;
        this.validator = new GradeValidator(studentRepo,subjectRepo);
    }

    public void add(int idStudent, int idTeacher, int mark, LocalDate date) {
        Grade grade = new Grade(idStudent, idTeacher, mark, date);
        validator.validate(grade);
        repo.add(grade);
    }

    public void delete(int id) {
        repo.delete(id);
    }

    public void update(int id, int mark) {
        Grade grade = repo.readById(id);
        grade.setMark(mark);
        repo.update(grade);
    }

    public void update(int id, LocalDate date) {
        Grade grade = repo.readById(id);
        grade.setDateMark(date);
        repo.update(grade);
    }

    public void display() {
        for (Grade g : repo.read()) {
            System.out.println(g);
        }
    }
}
package org.catalog.service;

import org.catalog.model.Grade;
import org.catalog.repository.GradeRepository;

import java.time.LocalDate;

public class GradeService {

    private final GradeRepository repo;

    public GradeService(GradeRepository repo) {
        this.repo = repo;
    }

    public void add(int idStudent, int idTeacher, int mark, LocalDate date) {
        Grade grade = new Grade(idStudent, idTeacher, mark, date);
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
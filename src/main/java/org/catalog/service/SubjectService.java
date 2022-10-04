package org.catalog.service;

import org.catalog.model.Subject;
import org.catalog.repository.SubjectRepository;
import org.catalog.repository.TeacherRepository;
import org.catalog.validator.SubjectValidator;
import org.catalog.validator.TeacherValidator;

public class SubjectService {
    private final SubjectRepository repo;
    private final SubjectValidator validator;

    public SubjectService(SubjectRepository repo, TeacherRepository teacherRepository) {
        this.repo = repo;
        this.validator = new SubjectValidator(teacherRepository);
    }

    public void add(String name, int idTeacher) {
        Subject subject = new Subject(name, idTeacher);
        validator.validate(subject);
        repo.add(subject);
    }

    public void deleteById(int id) {
        repo.delete(id);
    }

    public void update(int id, String name) {
        Subject subject = repo.readById(id);
        subject.setName(name);
        repo.update(subject);
    }

    public void update(int id, int idTeacher) {
        Subject subject = repo.readById(id);
        subject.setIdTeacher(idTeacher);
        repo.update(subject);
    }

    public void display() {
        for (Subject subject : repo.read()) {
            System.out.println(subject);
        }
    }

}

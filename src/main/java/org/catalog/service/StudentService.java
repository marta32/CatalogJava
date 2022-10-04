package org.catalog.service;

import org.catalog.model.Student;
import org.catalog.repository.StudentRepository;
import org.catalog.validator.StudentValidator;

import java.time.LocalDate;

public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public void add(String name, LocalDate birthday) {
        Student student = new Student(name, birthday);
        StudentValidator studentValidator = new StudentValidator();
        studentValidator.validate(student);
        repo.add(student);
    }

    public void deleteById(int id) {
        repo.delete(id);
    }

    public void update(int id, String name) {
        Student student = repo.readById(id);
        student.setName(name);
        repo.update(student);
    }

    public void update(int id, LocalDate birthday) {
        Student student = repo.readById(id);
        student.setBirthday(birthday);
        repo.update(student);
    }

    public void display() {
        for (Student s : repo.read()) {
            System.out.println(s);
        }
    }
}
package org.catalog.service;

import org.catalog.model.Teacher;
import org.catalog.repository.TeacherRepository;

import java.time.LocalDate;

public class TeacherService {
    private final TeacherRepository repo;

    public TeacherService(TeacherRepository repo) {
        this.repo = repo;
    }

    public void add(String name, LocalDate birthday) {
        Teacher teacher = new Teacher(name, birthday);
        Validator.validate(teacher);
        repo.add(teacher);
    }

    public void display() {
        for (Teacher t : repo.read()) {
            System.out.println(t);
        }
    }

    public void deleteById(int id) {
        repo.delete(id);
    }

    public void update(int id, String name) {
        Teacher teacher = repo.readById(id);
        teacher.setName(name);
        repo.update(teacher);
    }

    public void update(int id, LocalDate birthday) {
        Teacher teacher = repo.readById(id);
        teacher.setBirthday(birthday);
        repo.update(teacher);
    }


}
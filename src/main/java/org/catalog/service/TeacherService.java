package org.catalog.service;

import org.catalog.model.Teacher;
import org.catalog.repository.TeacherRepository;
import org.catalog.validator.TeacherValidator;

import java.time.LocalDate;

public class TeacherService {
    private final TeacherRepository repo;

    public TeacherService(TeacherRepository repo) {
        this.repo = repo;
    }

    public void add(String first_name, String last_name, LocalDate birthday) {
        Teacher teacher = new Teacher(first_name,last_name, birthday);
        TeacherValidator teacherValidator =new TeacherValidator();
        teacherValidator.validate(teacher);
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

    public void update(int id, String first_name, String last_name) {
        Teacher teacher = repo.readById(id);
        teacher.setFirst_name (first_name);
        teacher.setLast_name (last_name);
        repo.update(teacher);
    }

    public void update(int id, LocalDate birthday) {
        Teacher teacher = repo.readById(id);
        teacher.setBirthday(birthday);
        repo.update(teacher);
    }

}
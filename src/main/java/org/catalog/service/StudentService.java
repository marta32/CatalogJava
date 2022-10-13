package org.catalog.service;

import org.catalog.model.Grade;
import org.catalog.model.Student;
import org.catalog.repository.GradeRepository;
import org.catalog.repository.StudentRepository;
import org.catalog.validator.StudentValidator;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    private final StudentRepository repo;

    private final GradeRepository repoGrades;

    public StudentService(StudentRepository repo, GradeRepository repoGrades) {
        this.repo = repo;
        this.repoGrades = repoGrades;
    }

    public void add(String first_name, String last_name, LocalDate birthday) {
        Student student = new Student(first_name, last_name, birthday);
        StudentValidator studentValidator = new StudentValidator();
        studentValidator.validate(student);
        repo.add(student);
    }

    public void deleteById(int id) {
        repo.delete(id);
    }

    public void update(int id, String first_name, String last_name) {
        Student student = repo.readById(id);
        student.setFirst_name(first_name);
        student.setLast_name(last_name);
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

    public void displayTopThree() {
        Map<Integer, Double> studentGrades = repoGrades.read().stream()
                .collect(Collectors.groupingBy(Grade::getIdStudent, Collectors.averagingDouble(Grade::getMark)))
                .entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        for (Map.Entry<Integer, Double> entry : studentGrades.entrySet()) {
            Student student = repo.readById(entry.getKey());
            System.out.println("First name: " + student.getFirst_name() + ", last name: " + student.getLast_name() +
                    ", AVG_grade = " + entry.getValue());
        }
    }

//    public void displaySummerBirthday(){
//        repo.read().stream().filter(s->s.getBirthday(),)
//
//    }
}
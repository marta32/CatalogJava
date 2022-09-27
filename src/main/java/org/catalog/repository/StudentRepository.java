package org.catalog.repository;

import org.catalog.model.Student;

import java.util.List;

public interface StudentRepository {

    void add(Student student);

    void delete(int id);

    void update(Student student);

    List<Student> read();

    Student readById(int id);

}
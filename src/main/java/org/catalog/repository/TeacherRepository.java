package org.catalog.repository;

import org.catalog.model.Teacher;

import java.util.List;

public interface TeacherRepository {

    void add(Teacher teacher);

    void delete(int id);

    void update(Teacher teacher);

    List<Teacher> read();

    Teacher readById(int id);

}

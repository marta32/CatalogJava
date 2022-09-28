package org.catalog.repository;

import org.catalog.model.Subject;

import java.util.List;

public interface SubjectRepository {
    void add(Subject subject);

    void delete(int id);

    void update(Subject subject);

    List<Subject> read();

    Subject readById(int id);

}

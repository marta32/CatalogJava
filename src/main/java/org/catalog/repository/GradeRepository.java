package org.catalog.repository;

import org.catalog.model.Grade;

import java.util.List;

public interface GradeRepository {

    void add(Grade grade);
    void delete(int id);
    void update(Grade grade);
    List<Grade> read();
    Grade readById(int id);
}

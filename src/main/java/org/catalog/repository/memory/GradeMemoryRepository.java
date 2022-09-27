package org.catalog.repository.memory;

import org.catalog.repository.GradeRepository;

import java.time.LocalDate;

public class GradeMemoryRepository implements GradeRepository {
    int idMark;
    int idStudent;
    int idDisciplina;
    String mark;
    LocalDate dateMark;
}
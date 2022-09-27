package org.catalog.repository.memory;

import org.catalog.repository.MarkRepository;

import java.time.LocalDate;

public class MarkMemoryRepository implements MarkRepository {
    int idMark;
    int idStudent;
    int idDisciplina;
    String mark;
    LocalDate dateMark;
}
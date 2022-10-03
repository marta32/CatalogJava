package org.catalog.repository.memory;

import org.catalog.model.Grade;
import org.catalog.repository.GradeRepository;

import java.util.ArrayList;
import java.util.List;

public class GradeMemoryRepository implements GradeRepository {

    private int counter = 1;
    private final List<Grade> repo = new ArrayList<>();

    @Override
    public void add(Grade grade) {
        grade.setId(counter);
        counter++;
        repo.add(grade);
    }

    @Override
    public void delete(int id) {
        int i = 0;
        while (i < repo.size()) {
            if (repo.get(i).getId() == id) {
                repo.remove(repo.get(i));
                break;
            }
            i++;
        }
    }

    @Override
    public void update(Grade grade) {
        int i = 0;
        while (i < repo.size()) {
            if (repo.get(i).getId() == grade.getId()) {
                repo.get(i).setMark(grade.getMark());
                repo.get(i).setDateMark(grade.getDateMark());
                break;
            }
            i++;
        }
    }

    @Override
    public List<Grade> read() {
        return repo;
    }

    @Override
    public Grade readById(int id) {
        int i = 0;
        while (i < repo.size()) {
            if (repo.get(i).getId() == id) {
                return repo.get(i);
            }
            i++;
        }
        return null;
    }
}
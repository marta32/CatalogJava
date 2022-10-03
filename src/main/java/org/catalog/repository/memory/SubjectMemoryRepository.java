package org.catalog.repository.memory;

import org.catalog.model.Subject;
import org.catalog.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;

public class SubjectMemoryRepository implements SubjectRepository {

    private static int counter = 1;

    private final List<Subject> repo = new ArrayList<>();

    @Override
    public void add(Subject subject) {
        subject.setId(counter);
        counter++;
        repo.add(subject);
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
    public void update(Subject subject) {
        int i = 0;
        while (i < repo.size()) {
            if (repo.get(i).getId() == subject.getId()) {
                repo.get(i).setName(subject.getName());
                repo.get(i).setIdTeacher(subject.getIdTeacher());
                break;
            }
            i++;
        }
    }

    @Override
    public List<Subject> read() {
        return repo;
    }

    @Override
    public Subject readById(int id) {
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
package org.catalog.repository.memory;

import org.catalog.model.Teacher;
import org.catalog.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class TeacherMemoryRepository implements TeacherRepository {

    private static int counter = 1;
    private final List<Teacher> repo = new ArrayList<>();

    @Override
    public void add(Teacher teacher) {
        teacher.setId(counter);
        counter++;
        repo.add(teacher);
    }

    @Override
    public void delete(int id) {
        int i = 0;
        while (i < repo.size()) {
            if (repo.get(i).getId() == id) {
                repo.remove(i);
                break;
            }
            i++;
        }
    }

    @Override
    public void update(Teacher teacher) {
        int i = 0;
        while (i < repo.size()) {
            if (repo.get(i).getId() == teacher.getId()) {
                repo.get(i).setName(teacher.getName());
                repo.get(i).setBirthday(teacher.getBirthday());
                break;
            }
            i++;
        }
    }

    @Override
    public List<Teacher> read() {
        return repo;
    }

    @Override
    public Teacher readById(int id) {
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
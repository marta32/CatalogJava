package org.catalog.repository.memory;

import org.catalog.model.Student;
import org.catalog.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentMemoryRepository implements StudentRepository {

    private static int counter = 1;
    private final List<Student> repo = new ArrayList<>();

    @Override
    public void add(Student student) {
        student.setId(counter);
        counter++;
        repo.add(student);
    }

    @Override
    public List<Student> read() {
        return repo;
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
    public void update(Student student) {
        int i = 0;
        while (i < repo.size()) {
            if (repo.get(i).getId() == student.getId()){
                repo.get(i).setName(student.getName());
                repo.get(i).setBirthday(student.getBirthday());
                break;
            }
            i++;
        }
    }

    @Override
    public Student readById(int id) {
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
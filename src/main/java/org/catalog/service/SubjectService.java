package org.catalog.service;

import org.catalog.model.Subject;
import org.catalog.repository.SubjectRepository;

public class SubjectService {
    private final SubjectRepository repo;

    public SubjectService(SubjectRepository repo) {
        this.repo = repo;
    }

    public void add(String name, int idTeacher) {
        Subject subject = new Subject(name, idTeacher);
        repo.add(subject);
    }

    public void deleteById(int id) {
        repo.delete(id);
    }

    public void update(int id, String name) {
        Subject subject = repo.readById(id);
        subject.setName(name);
        repo.update(subject);
    }

    public void update(int id, int idTeacher) {
        Subject subject = repo.readById(id);
        subject.setIdTeacher(idTeacher);
        repo.update(subject);
    }

    public void display(){
        for(Subject subject: repo.read()){
            System.out.println(subject);
        }
    }

}

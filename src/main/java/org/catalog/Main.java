package org.catalog;

import org.catalog.repository.StudentRepository;
import org.catalog.repository.memory.StudentMemoryRepository;
import org.catalog.service.StudentService;

import java.time.LocalDate;

public class Main {

    private static StudentRepository studentRepository = new StudentMemoryRepository();
    private static StudentService studentService = new StudentService(studentRepository);

    public static void main(String[] args) {

        studentService.add("Marta", LocalDate.of(1996, 2, 23));
        studentService.add("Sorana", LocalDate.of(1999, 3, 2));

        studentService.display();

        studentService.deleteById(1);

        studentService.display();

        studentService.update(2, "Teofana");

        studentService.display();

        studentService.update(2, LocalDate.of(1998,4,11));

        studentService.display();
    }
}
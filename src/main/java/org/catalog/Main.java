package org.catalog;

import org.catalog.repository.StudentRepository;
import org.catalog.repository.TeacherRepository;
import org.catalog.repository.memory.StudentMemoryRepository;
import org.catalog.repository.memory.TeacherMemoryRepository;
import org.catalog.service.StudentService;
import org.catalog.service.TeacherService;

import java.time.LocalDate;

public class Main {

    private static StudentRepository studentRepository = new StudentMemoryRepository();
    private static StudentService studentService = new StudentService(studentRepository);

    private static TeacherRepository teacherRepository = new TeacherMemoryRepository();
    private static TeacherService teacherService = new TeacherService(teacherRepository);

    public static void main(String[] args) {

//        studentService.add("Marta", LocalDate.of(1996, 2, 23));
//        studentService.add("Sorana", LocalDate.of(1999, 3, 2));
//        studentService.display();
//        studentService.deleteById(1);
//        studentService.display();
//        studentService.update(2, "Teofana");
//        studentService.display();
//        studentService.update(2, LocalDate.of(1998,4,11));
//        studentService.display();

//        teacherService.add("Marta", LocalDate.of(1996,2,23));
//        teacherService.add("Pavel", LocalDate.of(1996,7,29));
//        teacherService.add("Vlad", LocalDate.of(1995,12,9));
//        teacherService.display();
//        teacherService.deleteById(1);
//        teacherService.display();
//        teacherService.update(2,"Maria");
//        teacherService.display();
//        teacherService.update(2,LocalDate.of(1971,5,10));
//        teacherService.display();
//
//        System.out.println("MENIU:");
//        System.out.println("Tasta 1 - Add teacher");
//        System.out.println("Tasta 2 - Add student");
//        System.out.println("Tasta 3 - Add subject");
//        System.out.println("Tasta 4 - Add  grade");
//        System.out.println("Tasta 5 - Stergere Profesor");
//        System.out.println("Tasta 6 - Stergere Elev");
//        System.out.println("Tasta 7 - Stergere Disciplina");
//        System.out.println("Tasta 8 - Stergere Nota");
//        System.out.println("Tasta 9 - Modi Nota");
//





    }
}
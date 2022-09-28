package org.catalog;

import org.catalog.repository.StudentRepository;
import org.catalog.repository.SubjectRepository;
import org.catalog.repository.TeacherRepository;
import org.catalog.repository.memory.StudentMemoryRepository;
import org.catalog.repository.memory.SubjectMemoryRepository;
import org.catalog.repository.memory.TeacherMemoryRepository;
import org.catalog.service.StudentService;
import org.catalog.service.SubjectService;
import org.catalog.service.TeacherService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static StudentRepository studentRepository = new StudentMemoryRepository();
    private static StudentService studentService = new StudentService(studentRepository);

    private static TeacherRepository teacherRepository = new TeacherMemoryRepository();
    private static TeacherService teacherService = new TeacherService(teacherRepository);

    private static SubjectRepository subjectRepository = new SubjectMemoryRepository();
    private static SubjectService subjectService = new SubjectService(subjectRepository);

    public static void menu() {
        System.out.println("========= MENU =========");
        System.out.println("Tap 0 - Exit");
        System.out.println("Tap 1 - Add teacher");
        System.out.println("Tap 2 - Add student");
        System.out.println("Tap 3 - Add subject");
        System.out.println("Tap 4 - Add grade");
        System.out.println("Tap 5 - Delete teacher");
        System.out.println("Tap 6 - Delete student");
        System.out.println("Tap 7 - Delete subject");
        System.out.println("Tap 8 - Delete grade");
        System.out.println("Tap 9 - Update teacher's name");
        System.out.println("Tap 10 - Update student's name");
        System.out.println("Tap 11 - Update subject's name");
        System.out.println("Tap 12 - Update mark");
        System.out.println("Tap 13 - Update teacher's birthday date");
        System.out.println("Tap 14 - Update student's birthday date");
        System.out.println("Tap 15 - Update subject's teacher id");
        System.out.println("Tap 16 - Update grade's date");
        System.out.println("Tap 17 - Display teachers");
        System.out.println("Tap 18 - Display students");
        System.out.println("Tap 19 - Display subjects");
        System.out.println("Tap 20 - Display grades");
    }

    public static void options() {

        Scanner cin = new Scanner(System.in);
        System.out.println("Tap your option ");
        int op = cin.nextInt();

        switch (op) {
            case 0:
                return;

            case 1: {
                System.out.println("Name: ");
                String name = cin.next();
                System.out.println("Tape birthday date");
                System.out.println("Year: ");
                int year = cin.nextInt();
                System.out.println("Month: ");
                int month = cin.nextInt();
                System.out.println("Day: ");
                int day = cin.nextInt();
                teacherService.add(name, LocalDate.of(year, month, day));
                options();
                break;
            }

            case 2: {
                System.out.println("Name: ");
                String name = cin.next();
                System.out.println("Tape birthday date");
                System.out.println("Year: ");
                int year = cin.nextInt();
                System.out.println("Month: ");
                int month = cin.nextInt();
                System.out.println("Day: ");
                int day = cin.nextInt();
                studentService.add(name, LocalDate.of(year, month, day));
                options();
                break;
            }

            case 3: {
                System.out.println("Name: ");
                String name = cin.next();
                System.out.println("Type id's teacher");
                int idTeacher = cin.nextInt();
                subjectService.add(name, idTeacher);
                options();
                break;
            }

            case 5: {
                System.out.println("Tap teacher id ");
                int id = cin.nextInt();
                teacherService.deleteById(id);
                options();
                break;
            }

            case 6: {
                System.out.println("Tap student id ");
                int id = cin.nextInt();
                studentService.deleteById(id);
                options();
                break;
            }

            case 7: {
                System.out.println("Tap subject id ");
                int id = cin.nextInt();
                subjectService.deleteById(id);
                options();
                break;
            }

            case 9: {
                System.out.println("Tap teacher id ");
                int id = cin.nextInt();
                System.out.println("New name ");
                String name = cin.next();
                teacherService.update(id, name);
                options();
                break;
            }

            case 10: {
                System.out.println("Tap student id ");
                int id = cin.nextInt();
                System.out.println("New name ");
                String name = cin.next();
                studentService.update(id, name);
                options();
                break;
            }

            case 11: {
                System.out.println("Tap subject id ");
                int id = cin.nextInt();
                System.out.println("New name ");
                String name = cin.next();
                subjectService.update(id, name);
                options();
                break;
            }

            case 13: {
                System.out.println("Tap teacher id ");
                int id = cin.nextInt();
                System.out.println("New year ");
                int year = cin.nextInt();
                System.out.println("New month: ");
                int month = cin.nextInt();
                System.out.println("New day: ");
                int day = cin.nextInt();
                teacherService.update(id, LocalDate.of(year, month, day));
                options();
                break;
            }

            case 14: {
                System.out.println("Tap student id ");
                int id = cin.nextInt();
                System.out.println("New year ");
                int year = cin.nextInt();
                System.out.println("New month: ");
                int month = cin.nextInt();
                System.out.println("New day: ");
                int day = cin.nextInt();
                studentService.update(id, LocalDate.of(year, month, day));
                options();
                break;
            }

            case 15: {
                System.out.println("Tap subject id ");
                int id = cin.nextInt();
                System.out.println("New teacher id");
                int idTeacher = cin.nextInt();
                subjectService.update(id, idTeacher);
                options();
                break;
            }

            case 17: {
                System.out.println("===== TEACHERS'S LIST =====");
                teacherService.display();
                options();
                break;
            }

            case 18: {
                System.out.println("===== STUDENTS'S LIST =====");
                studentService.display();
                options();
                break;
            }
            case 19: {
                System.out.println("===== SUBJECTS'S LIST =====");
                subjectService.display();
                options();
                break;
            }

        }
    }

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
//        teacherService.add("Pavelida", LocalDate.of(1996,7,29));
//        teacherService.add("Bella", LocalDate.of(1995,12,9));
//        teacherService.display();
//        teacherService.deleteById(1);
//        teacherService.display();
//        teacherService.update(2,"Maria");
//        teacherService.display();
//        teacherService.update(2,LocalDate.of(1971,5,10));
//        teacherService.display();

//        subjectService.add("Matematica", 3);
//        subjectService.add("Informatica", 10);
//        subjectService.add("Limba engleza", 7);
//        subjectService.add("Limba romana", 1);
//        subjectService.display();
//        subjectService.deleteById(1);
//        subjectService.display();
//        subjectService.update(2,"Fizica");
//        subjectService.display();
//        subjectService.update(2,12);
//        subjectService.display();

        menu();
        options();


    }
}
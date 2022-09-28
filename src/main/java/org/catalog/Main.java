package org.catalog;

import org.catalog.repository.GradeRepository;
import org.catalog.repository.StudentRepository;
import org.catalog.repository.SubjectRepository;
import org.catalog.repository.TeacherRepository;
import org.catalog.repository.memory.GradeMemoryRepository;
import org.catalog.repository.memory.StudentMemoryRepository;
import org.catalog.repository.memory.SubjectMemoryRepository;
import org.catalog.repository.memory.TeacherMemoryRepository;
import org.catalog.service.GradeService;
import org.catalog.service.StudentService;
import org.catalog.service.SubjectService;
import org.catalog.service.TeacherService;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static StudentRepository studentRepository = new StudentMemoryRepository();
    private static StudentService studentService = new StudentService(studentRepository);

    private static TeacherRepository teacherRepository = new TeacherMemoryRepository();
    private static TeacherService teacherService = new TeacherService(teacherRepository);

    private static SubjectRepository subjectRepository = new SubjectMemoryRepository();
    private static SubjectService subjectService = new SubjectService(subjectRepository);

    private static GradeRepository gradeRepository = new GradeMemoryRepository();
    private static GradeService gradeService = new GradeService(gradeRepository);

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
        System.out.println("Tap 12 - Update grade");
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
        System.out.print("Tap your option ");
        int op = cin.nextInt();

        switch (op) {
            case 0:
                return;

            case 1: {
                System.out.print("Name: ");
                String name = cin.next();
                System.out.println("Tape birth date");
                System.out.print("Year: ");
                int year = cin.nextInt();
                System.out.print("Month: ");
                int month = cin.nextInt();
                System.out.print("Day: ");
                int day = cin.nextInt();
                teacherService.add(name, LocalDate.of(year, month, day));
                options();
                break;
            }

            case 2: {
                System.out.print("Name: ");
                String name = cin.next();
                System.out.println("Tape birth date");
                System.out.print("Year: ");
                int year = cin.nextInt();
                System.out.print("Month: ");
                int month = cin.nextInt();
                System.out.print("Day: ");
                int day = cin.nextInt();
                studentService.add(name, LocalDate.of(year, month, day));
                options();
                break;
            }

            case 3: {
                System.out.print("Name: ");
                String name = cin.next();
                System.out.print("Teacher's id: ");
                int idTeacher = cin.nextInt();
                subjectService.add(name, idTeacher);
                options();
                break;
            }

            case 4: {
                System.out.print("Student's id: ");
                int idStudent = cin.nextInt();
                System.out.print("Teacher's id: ");
                int idTeacher = cin.nextInt();
                System.out.print("Mark: ");
                int mark = cin.nextInt();
                LocalDate date = LocalDate.now();
                gradeService.add(idStudent, idTeacher, mark, date);
                options();
                break;
            }

            case 5: {
                System.out.print("Teacher's id: ");
                int id = cin.nextInt();
                teacherService.deleteById(id);
                options();
                break;
            }

            case 6: {
                System.out.print("Student's id: ");
                int id = cin.nextInt();
                studentService.deleteById(id);
                options();
                break;
            }

            case 7: {
                System.out.print("Subject's id: ");
                int id = cin.nextInt();
                subjectService.deleteById(id);
                options();
                break;
            }

            case 8: {
                System.out.print("Grade's id: ");
                int id = cin.nextInt();
                gradeService.delete(id);
                options();
                break;
            }

            case 9: {
                System.out.print("Teacher's id: ");
                int id = cin.nextInt();
                System.out.print("New name: ");
                String name = cin.next();
                teacherService.update(id, name);
                options();
                break;
            }

            case 10: {
                System.out.print("Student's id: ");
                int id = cin.nextInt();
                System.out.print("New name: ");
                String name = cin.next();
                studentService.update(id, name);
                options();
                break;
            }

            case 11: {
                System.out.print("Subject's id: ");
                int id = cin.nextInt();
                System.out.print("New name: ");
                String name = cin.next();
                subjectService.update(id, name);
                options();
                break;
            }

            case 12: {
                System.out.print("Grade's id: ");
                int id = cin.nextInt();
                System.out.print("New grade: ");
                int mark = cin.nextInt();
                gradeService.update(id, mark);
                options();
                break;
            }

            case 13: {
                System.out.print("Teacher's id: ");
                int id = cin.nextInt();
                System.out.print("New year: ");
                int year = cin.nextInt();
                System.out.print("New month: ");
                int month = cin.nextInt();
                System.out.print("New day: ");
                int day = cin.nextInt();
                teacherService.update(id, LocalDate.of(year, month, day));
                options();
                break;
            }

            case 14: {
                System.out.print("Student's id: ");
                int id = cin.nextInt();
                System.out.print("New year: ");
                int year = cin.nextInt();
                System.out.print("New month: ");
                int month = cin.nextInt();
                System.out.print("New day: ");
                int day = cin.nextInt();
                studentService.update(id, LocalDate.of(year, month, day));
                options();
                break;
            }

            case 15: {
                System.out.print("Subject's id: ");
                int id = cin.nextInt();
                System.out.print("New teacher id: ");
                int idTeacher = cin.nextInt();
                subjectService.update(id, idTeacher);
                options();
                break;
            }

            case 16: {
                System.out.print("Grade's id: ");
                int id = cin.nextInt();
                System.out.print("Tap new date");
                System.out.println("Year: ");
                int year = cin.nextInt();
                System.out.print("Month: ");
                int month = cin.nextInt();
                System.out.print("Day: ");
                int day = cin.nextInt();
                gradeService.update(id, LocalDate.of(year, month, day));
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
            case 20: {
                System.out.println("===== GRADE'S LIST =====");
                gradeService.display();
                options();
                break;
            }
        }
    }

    public static void main(String[] args) {

        menu();
        options();

    }
}
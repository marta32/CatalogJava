package org.catalog;

import org.catalog.exceptions.InvalidDateException;
import org.catalog.exceptions.InvalidNameException;
import org.catalog.repository.GradeRepository;
import org.catalog.repository.StudentRepository;
import org.catalog.repository.SubjectRepository;
import org.catalog.repository.TeacherRepository;
import org.catalog.repository.file.GradeFileRepository;
import org.catalog.repository.file.StudentFileRepository;
import org.catalog.repository.file.SubjectFileRepository;
import org.catalog.repository.file.TeacherFileRepository;
import org.catalog.service.GradeService;
import org.catalog.service.StudentService;
import org.catalog.service.SubjectService;
import org.catalog.service.TeacherService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static StudentRepository studentRepository = new StudentFileRepository();
    private static StudentService studentService = new StudentService(studentRepository);

    private static TeacherRepository teacherRepository = new TeacherFileRepository();
    private static TeacherService teacherService = new TeacherService(teacherRepository);

    private static SubjectRepository subjectRepository = new SubjectFileRepository();
    private static SubjectService subjectService = new SubjectService(subjectRepository,teacherRepository);

    private static GradeRepository gradeRepository = new GradeFileRepository();
    private static GradeService gradeService = new GradeService(gradeRepository,studentRepository,subjectRepository);

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
        System.out.println("Tap 13 - Update teacher's birth day");
        System.out.println("Tap 14 - Update student's birth day");
        System.out.println("Tap 15 - Update subject's teacher id");
        System.out.println("Tap 16 - Update grade's date");
        System.out.println("Tap 17 - Display teachers");
        System.out.println("Tap 18 - Display students");
        System.out.println("Tap 19 - Display subjects");
        System.out.println("Tap 20 - Display grades");
    }

    public static void options() {

        Scanner cin = new Scanner(System.in);
        cin.useDelimiter("\n");
        System.out.print("Tap your option ");
        int op = cin.nextInt();

        try {
            switch (op) {

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
                    break;
                }

                case 3: {
                    System.out.print("Name: ");
                    String name = cin.next();
                    System.out.print("Teacher's id: ");
                    int idTeacher = cin.nextInt();
                    subjectService.add(name, idTeacher);
                    break;
                }

                case 4: {
                    System.out.print("Student's id: ");
                    int idStudent = cin.nextInt();
                    System.out.print("Subject's id: ");
                    int idTeacher = cin.nextInt();
                    System.out.print("Mark: ");
                    int mark = cin.nextInt();
                    LocalDate date = LocalDate.now();
                    gradeService.add(idStudent, idTeacher, mark, date);
                    break;
                }

                case 5: {
                    System.out.print("Teacher's id: ");
                    int id = cin.nextInt();
                    teacherService.deleteById(id);
                    break;
                }

                case 6: {
                    System.out.print("Student's id: ");
                    int id = cin.nextInt();
                    studentService.deleteById(id);
                    break;
                }

                case 7: {
                    System.out.print("Subject's id: ");
                    int id = cin.nextInt();
                    subjectService.deleteById(id);
                    break;
                }

                case 8: {
                    System.out.print("Grade's id: ");
                    int id = cin.nextInt();
                    gradeService.delete(id);
                    break;
                }

                case 9: {
                    System.out.print("Teacher's id: ");
                    int id = cin.nextInt();
                    System.out.print("New name: ");
                    String name = cin.next();
                    teacherService.update(id, name);
                    break;
                }

                case 10: {
                    System.out.print("Student's id: ");
                    int id = cin.nextInt();
                    System.out.print("New name: ");
                    String name = cin.next();
                    studentService.update(id, name);
                    break;
                }

                case 11: {
                    System.out.print("Subject's id: ");
                    int id = cin.nextInt();
                    System.out.print("New name: ");
                    String name = cin.next();
                    subjectService.update(id, name);
                    break;
                }

                case 12: {
                    System.out.print("Grade's id: ");
                    int id = cin.nextInt();
                    System.out.print("New grade: ");
                    int mark = cin.nextInt();
                    gradeService.update(id, mark);
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
                    break;
                }

                case 15: {
                    System.out.print("Subject's id: ");
                    int id = cin.nextInt();
                    System.out.print("New teacher id: ");
                    int idTeacher = cin.nextInt();
                    subjectService.update(id, idTeacher);
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
                    break;
                }

                case 17: {
                    System.out.println("===== TEACHERS'S LIST =====");
                    teacherService.display();
                    break;
                }
                case 18: {
                    System.out.println("===== STUDENTS'S LIST =====");
                    studentService.display();
                    break;
                }
                case 19: {
                    System.out.println("===== SUBJECTS'S LIST =====");
                    subjectService.display();
                    break;
                }
                case 20: {
                    System.out.println("===== GRADE'S LIST =====");
                    gradeService.display();
                    break;
                }
            }
        } catch (InvalidNameException | InvalidDateException exception) {
            System.out.println(exception.getMessage());
        }
        if (op != 0) {
            options();
        }
    }

    public static void main(String[] args) {

        menu();
        options();

    }
}
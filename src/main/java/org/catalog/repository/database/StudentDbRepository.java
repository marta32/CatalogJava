package org.catalog.repository.datebase;

import org.catalog.model.Student;
import org.catalog.repository.StudentRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDbRepository implements StudentRepository {
    private final Connection connection;

    public StudentDbRepository() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/catalog", "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Student student) {
        try (Statement stmt = connection.createStatement()) {
            String sql = "INSERT INTO students (first_name, last_name, date_of_birth) VALUES('"
                    + student.getFirst_name() + "','" + student.getLast_name() + "','"
                    + student.getBirthday() + "')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Statement stmt = connection.createStatement()) {
            String sql = " UPDATE grades "
                       + " SET student_id = "+ null + " WHERE student_id = " + id + ";"
                       + " DELETE FROM students " + " WHERE student_id = " + id;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Student student) {
        try (Statement stmt = connection.createStatement()) {
            String sql = "UPDATE students "
                    + "SET first_name = '" + student.getFirst_name() + "', last_name = '" + student.getLast_name()
                    + "', date_of_birth = '" + student.getBirthday() + "'"
                    + "WHERE student_id = " + student.getId();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> read() {
        List<Student> students = new ArrayList<>();
        try(Statement stmt = connection.createStatement()) {
            String sql = " SELECT * FROM students s";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("student_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                LocalDate date_of_birth = rs.getDate("date_of_birth").toLocalDate();
                Student student = new Student(id,first_name,last_name,date_of_birth);
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student readById(int id) {
        List<Student> students = read();
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
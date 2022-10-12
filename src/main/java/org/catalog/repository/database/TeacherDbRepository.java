package org.catalog.repository.datebase;

import org.catalog.model.Teacher;
import org.catalog.repository.TeacherRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherDbRepository implements TeacherRepository {

    private Connection connection;

    public TeacherDbRepository() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/catalog", "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Teacher teacher) {
        try (Statement stmt = connection.createStatement()) {
            String sql = "INSERT INTO teachers (first_name, last_name, date_of_birth) VALUES('"
                    + teacher.getFirst_name() + "','" + teacher.getLast_name() + "','"
                    + teacher.getBirthday() + "')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Statement stmt = connection.createStatement()) {
            String sql = " UPDATE subjects " + " SET teacher_id = " + null + " WHERE teacher_id = "+ id + ";"
                    + " DELETE FROM teachers WHERE teacher_id = " + id;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Teacher teacher) {
        try (Statement stmt = connection.createStatement()) {
            String sql = "UPDATE teachers "
                    + "SET first_name = '" + teacher.getFirst_name() + "', last_name = '" + teacher.getLast_name()
                    + "', date_of_birth = '" + teacher.getBirthday() + "'"
                    + "WHERE teacher_id = " + teacher.getId();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Teacher> read() {
        List<Teacher> teachers = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            String sql = "SELECT * FROM teachers ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("teacher_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                LocalDate date_of_birth = rs.getDate("date_of_birth").toLocalDate();
                Teacher teacher = new Teacher(id, first_name, last_name, date_of_birth);
                teachers.add(teacher);
            }
            return teachers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Teacher readById(int id) {
        List<Teacher> teachers = read();
        for (Teacher t : teachers) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}

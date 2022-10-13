package org.catalog.repository.database;

import org.catalog.model.Subject;
import org.catalog.repository.SubjectRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDbRepository implements SubjectRepository {

    private Connection connection;

    public SubjectDbRepository() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/catalog", "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Subject subject) {
        try (Statement stmt = connection.createStatement()) {
            String sql = "INSERT INTO subjects (name, teacher_id) VALUES('"
                    + subject.getName() + "','" + subject.getIdTeacher() + "')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Statement stmt = connection.createStatement()) {
            String sql = " UPDATE grades " + " SET subject_id = " + null + "WHERE subject_id = " + id + ";"
                    + " DELETE FROM subjects " + "WHERE subject_id = " + id;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Subject subject) {
        try (Statement stmt = connection.createStatement()) {
            String sql = "UPDATE subjects "
                    + "SET name = '" + subject.getName() + "', teacher_id = " + subject.getIdTeacher()
                    + "WHERE subject_id = " + subject.getId();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Subject> read() {
        List<Subject> subjects = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            String sql = " SELECT * FROM subjects s JOIN teachers t ON s.teacher_id = t.teacher_id";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("subject_id");
                String name = rs.getString("name");
                int idt = rs.getInt("teacher_id");
                Subject subject = new Subject(id, name, idt);
                subjects.add(subject);
            }
            return subjects;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Subject readById(int id) {
        try (Statement stmt = connection.createStatement()) {
            String sql = " SELECT * FROM subjects WHERE subject_id = "+id;
            ResultSet rs = stmt.executeQuery(sql);
            if( rs.next()) {
                int subject_id = rs.getInt("subject_id");
                String name = rs.getString("name");
                int idt = rs.getInt("teacher_id");
                return new Subject(id, name, idt);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

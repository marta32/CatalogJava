package org.catalog.repository.database;

import org.catalog.model.Grade;
import org.catalog.repository.GradeRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GradeDbRepository implements GradeRepository {

    private Connection connection;

    public GradeDbRepository() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/catalog", "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Grade grade) {
        try (Statement stmt = connection.createStatement()) {
            String sql = "INSERT INTO grades(student_id, subject_id, mark, date_of_mark) VALUES('"
                    + grade.getIdStudent() + "','" + grade.getIdSubject() + "',"
                    + grade.getMark() + ",'" + grade.getDateMark() + "')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Statement stmt = connection.createStatement()) {
            String sql = " DELETE FROM grades " + " WHERE grade_id = " + id;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Grade grade) {
        try (Statement stmt = connection.createStatement()) {
            String sql = "UPDATE grades "
                    + "SET student_id = '" + grade.getIdStudent() + "', subject_id = '" + grade.getIdSubject()
                    + "', mark = " + grade.getMark()
                    + ", date_of_mark= '" + grade.getDateMark() + "'"
                    + " WHERE grade_id = " + grade.getId();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Grade> read() {
        List<Grade> grades = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            String sql = "SELECT * FROM grades g JOIN students s ON g.student_id = s.student_id";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id0 = rs.getInt("grade_id");
                int id1 = rs.getInt("student_id");
                int id2 = rs.getInt("subject_id");
                int mark = rs.getInt("mark");
                LocalDate date_of_mark = rs.getDate("date_of_mark").toLocalDate();
                Grade grade = new Grade(id0, id1, id2, mark, date_of_mark);
                grades.add(grade);
            }
            return grades;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Grade readById(int id) {
        try (Statement stmt = connection.createStatement()) {
            String sql = "SELECT * FROM grades WHERE grade_id = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            if( rs.next()) {
                int id0 = rs.getInt("grade_id");
                int id1 = rs.getInt("student_id");
                int id2 = rs.getInt("subject_id");
                int mark = rs.getInt("mark");
                LocalDate date_of_mark = rs.getDate("date_of_mark").toLocalDate();
                return new Grade(id0, id1, id2, mark, date_of_mark);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

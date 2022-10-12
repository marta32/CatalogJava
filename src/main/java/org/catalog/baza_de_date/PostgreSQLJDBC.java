package org.catalog.baza_de_date;

import java.sql.*;

public class PostgreSQLJDBC {
    public static void main(String args[]) {
        Connection c = null;
        String QUERY = "SELECT * FROM students";
        try(Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/catalog", "postgres", "postgres");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
        ) {
            while(rs.next()){
                //Display values
                System.out.print("ID: " + rs.getInt("student_id"));
                System.out.print(", First name: " + rs.getString("first_name"));
                System.out.print(", Last name: " + rs.getString("last_name"));
                System.out.println(", Date of birth: " + rs.getString("date_of_birth"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Opened database successfully");
    }
}
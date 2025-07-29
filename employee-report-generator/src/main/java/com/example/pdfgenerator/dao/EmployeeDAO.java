package com.example.pdfgenerator.dao;

import com.example.pdfgenerator.model.Employee;
import java.sql.*;
import java.util.*;

public class EmployeeDAO {
    public static List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "mohana83330");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM employees");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Employee(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("salary"),
                        rs.getString("joining_date")
                ));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

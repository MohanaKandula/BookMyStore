package com.example.pdfgenerator;

import com.example.pdfgenerator.dao.EmployeeDAO;
import com.example.pdfgenerator.model.Employee;
import com.example.pdfgenerator.util.PDFGenerator;
import com.example.pdfgenerator.util.ReportZipper;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                List<Employee> employees = EmployeeDAO.getAllEmployees();
                if (employees != null && !employees.isEmpty()) {
                    PDFGenerator.generateReport(employees);
                    ReportZipper.zipReports();
                } else {
                    System.out.println("❌ No employee data found.");
                }
            }
        }, 0, 24 * 60 * 60 * 1000); // every 24 hrs

        // Keep the app running (demo purpose)
        System.out.println("⏳ Scheduler started. Press Ctrl+C to stop.");
    }
}

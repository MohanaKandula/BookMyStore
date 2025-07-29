package com.example.pdfgenerator.util;

import com.example.pdfgenerator.model.Employee;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class PDFGenerator {
    public static String generateReport(java.util.List<Employee> employees) {
        Document document = new Document();
        try {
            File reportsDir = new File("reports");
            if (!reportsDir.exists()) reportsDir.mkdirs();

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filename = "reports/employee_report_" + timestamp + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();

            // Logo
            Image logo = Image.getInstance(PDFGenerator.class.getClassLoader().getResource("logo.png"));
            logo.scaleAbsolute(100, 50);
            logo.setAlignment(Element.ALIGN_RIGHT);
            document.add(logo);

            // Title
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.DARK_GRAY);
            Paragraph title = new Paragraph("Employee Report", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("Generated on: " + new Date()));
            document.add(Chunk.NEWLINE);

            // Table
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);

            String[] headers = {"ID", "Name", "Department", "Salary", "Join Date"};
            for (String h : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(h));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                table.addCell(cell);
            }

            for (Employee emp : employees) {
                table.addCell(emp.getId());
                table.addCell(emp.getName());
                table.addCell(emp.getDepartment());
                table.addCell(emp.getSalary());
                table.addCell(emp.getJoinDate());
            }

            document.add(table);

            // Footer
            Paragraph footer = new Paragraph("Confidential - Company XYZ", FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 10));
            footer.setAlignment(Element.ALIGN_CENTER);
            document.add(footer);

            document.close();
            System.out.println("✅ PDF generated: " + filename);
            return filename;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.example.pdfgenerator.util;

import java.io.*;
import java.nio.file.*;
import java.util.zip.*;

public class ReportZipper {
    public static void zipReports() {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("employee_reports.zip"))) {
            File[] files = new File("reports").listFiles();
            if (files == null) return;

            for (File file : files) {
                if (file.getName().endsWith(".pdf")) {
                    zos.putNextEntry(new ZipEntry(file.getName()));
                    Files.copy(file.toPath(), zos);
                    zos.closeEntry();
                }
            }
            System.out.println("✅ Reports zipped as employee_reports.zip");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

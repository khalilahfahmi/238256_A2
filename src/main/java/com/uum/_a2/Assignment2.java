/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum._a2;

import java.io.File;

public class Assignment2 {

    private static final String FILE_NAME = "Assignment2.xlsx";
    
    public void main(String[] args) {
        
        String workingDirectory = System.getProperty("user.dir");
        workingDirectory.replace("\\", "/");
        String filename = "/RealTime/src/Test_files.Assignment2";
        
        String absoluteFilePath = workingDirectory + File.separator + filename + "/MyThread1.java";
        String path = absoluteFilePath;
        System.out.println("My Thread 1");
        runFiles thread1 = new runFiles(path);
        
        System.out.println("");
        System.out.println("My Thread 2");
        String absoluteFilePath1 = workingDirectory + File.separator + filename + "/MyThread2.java";
        String path2 = absoluteFilePath1;
        runFiles thread2 = new runFiles(path2);   
    }
    
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Assignment 2");
        Object[][] datatypes = {{"Semester", thread1.getSem(path)},
        {"Course", thread1.getCourse(path)},
        {"Group", thread1.getGroup(path)},
        {"Task", thread1.getTask(path)}};
        
        int rowCount = 0;
         
        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);
             
            int columnCount = 0;
             
            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
             
        }
    try (FileOutputStream outputStream = new FileOutputStream("JavaBooks.xlsx")) {
            workbook.write(outputStream);
        }
}

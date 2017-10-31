/* 
 * Semester: A171
 * Course: STIW3054
 * Group: A
 * Task: Assignment 2
 * Matric Num: 238256
 * Name: Khalilah Binti Ahmad Fahmi
 */
package com.uum._a2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;

public class TestProcessFile extends Count{
    
    String st;
@Test
    public void ProcessFile(String path) throws FileNotFoundException, IOException {
        process(path);
    }
@Test
    public void process(String path) throws FileNotFoundException, IOException {
        String p = path;
        File f = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(f));
        countLine line = new countLine();
        
        while ((st = br.readLine()) != null) {
            int linenumber = line.countLine();
            int blankline = line.countLine();
            int comment = line.countLine();
            int actualLOC = line.countLine(linenumber, blankline, comment);
            int totalkeyword = line.countKeywords();
            int totalValue =line.countTotalValue();
            
            System.out.println(" LOC : " + linenumber);
            System.out.println(" Blank Line : " + blankline);
            System.out.println(" Comment : " + comment);
            System.out.println("The actual LOC: " + actualLOC );
            System.out.println("Number of keyword : " + totalkeyword);
            System.out.println("Total Value: " + totalValue);
        
        }
    }
}


   

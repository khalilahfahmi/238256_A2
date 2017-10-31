/* 
 * Semester: A171
 * Course: STIW3054
 * Group: A
 * Task: Assignment 2
 * Matric Num: 238256
 * Name: Khalilah Binti Ahmad Fahmi
 */
package com.uum._a2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.junit.Test;


public class TestCount {
 @Test   
    public int countLine(){
        int linenumber = 0;
        int blankline = 0;
        int comment = 0;
        int actualLOC = 0;
  
        try{
            
        File file =new File("/MyThread1.java");
        if(file.exists()){

    		    FileReader fr = new FileReader(file);
    		    LineNumberReader line = new LineNumberReader(fr);
                    String readLine= "";
    	            while (line.readLine() != null){
    	        	linenumber++;

                  
                    if (line.readLine().isEmpty()) {
                    blankline++;
                    }
                    
                     if ((line.startsWith("//")) || (line.startsWith("/*"))){
	            comment++;
                    while (!(line = fr.readLine()).endsWith("'*\'")) {
	            comment++; 
                    break;
	            }
                    }
                    }
                    actualLOC = linenumber - blankline - comment;
                    line.close();
                    
    		}else{
    			 System.out.println("File does not exists!");
                    }
                
            System.out.println(" LOC : " + linenumber);
            System.out.println(" Blank Line : " + blankline);
            System.out.println(" Comment : " + comment);
            System.out.println("The actual LOC: " + actualLOC );
    	}catch(IOException e){
    		e.printStackTrace();
    	}
       
        return actualLOC;
        
    }
    
    public static int countKeywords(File file) throws Exception {
		
		String[] keywordString = {"abstract", "assert", "boolean",
			"break", "byte", "case", "catch", "char", "class", "const",
			"continue", "default", "do", "double", "else", "enum",
			"extends", "for", "final", "finally", "float", "goto",
			"if", "implements", "import", "instanceof", "int",
			"interface", "long", "native", "new", "package", "private",
			"protected", "public", "return", "short", "static",
			"strictfp", "super", "switch", "synchronized", "this",
			"throw", "throws", "transient", "try", "void", "volatile",
			"while", "true", "false", "null"};

		Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
		int totalkeyword = 0;

		Scanner input = new Scanner(file);

		while (input.hasNext()) {
			String word = input.next();
			if (word.equals("//"))
				input.nextLine();
			else if (word.contains("\""))
				while (input.hasNext() && !input.next().contains("\"")) {}
			else if (word.contains("/*"))
				while (input.hasNext() && !input.next().contains("*/")) {}
			else if (keywordSet.contains(word))
				totalkeyword++;
		}

		return totalkeyword;
    }
    
    public int countTotalValue(int actualLOC, int totalkeyword) {
        int totalValue;
        totalValue = actualLOC + totalkeyword;
        return totalValue;
    }

        
    
}

    

    

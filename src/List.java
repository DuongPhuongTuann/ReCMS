import java.io.File;

import java.util.Scanner;

import java.io.FileNotFoundException;

public class List {
    public static void Listt(){

     try {
    	  File x = new File("C:\\Assignment-Pro-2\\QBs.dat");
    	  Scanner sc = new Scanner(x);
    	  String content = "";
    	  while(sc.hasNextLine()) {
    		  content += sc.nextLine()+"\r\n";
                  
    	  }
  	      System.out.println(content);
              
    	  sc.close();
    	} catch (FileNotFoundException e) {
    	  System.out.println("Error");
    	}
  }
}

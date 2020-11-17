

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public class Problem {
    public static void AddProblem() throws IOException {
   try{    Scanner s = new Scanner(System.in);
        String problemId, category, short_description,link ,author;
        double mark_weight;
        System.out.println("Enter Your Problem ID: ");
        problemId = s.nextLine();
        System.out.println("Enter Problem's category: ");
        category = s.nextLine();
        System.out.println("Enter Problem's Short Description: ");
        short_description = s.nextLine();
        System.out.println("Enter Link To Full Description: ");
        link = s.nextLine();
        System.out.println("Enter Problem's Author: ");
        author = s.nextLine();
        System.out.println("Enter Problem Mark's Weight: ");
        mark_weight = s.nextDouble();
        File f1 = new File("C:\\Assignment-Pro-2\\QBs.dat");
        if(!f1.exists()) {
            f1.createNewFile();
         }

         FileWriter fileWritter = new FileWriter(f1.getName(),true);
         BufferedWriter bw = new BufferedWriter(fileWritter);
         

         bw.write(problemId+","+category+","+short_description+","+link+","+author+","+mark_weight);
         
         bw.close();
         System.out.println("Add a new problem to the Question Bank Successfully\n");
      } catch(IOException e){
         e.printStackTrace();
      }
   }
}
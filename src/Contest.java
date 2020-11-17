
import java.io.BufferedWriter;
import java.io.File;

import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import static javafx.beans.binding.Bindings.and;

public class Contest {

    public static void Listttt() {
        System.out.println("Generate a new Contest successfully");
        try {

            File x = new File("C:\\Assignment-Pro-2\\QBz.txt");
            Scanner sc = new Scanner(x);
            Random rd = new Random();
            String content = "ContestID:"+rd.nextInt(100000)+"\n";    
            ArrayList<String> users = storage("C:\\Assignment-Pro-2\\QBz.txt");
            ArrayList<String> id = new ArrayList();
            users.add(0, content);
            
            String a="ContestID: "+rd.nextInt(10000);
            id.add(a);
            while (sc.hasNextLine()) {
                content += sc.nextLine() + "\r\n";
                
            }
        
            write_to_file("C:\\Assignment-Pro-2\\Contest_TimeStamp.txt", users);
            
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

    }

    public static ArrayList<String> storage(String name_of_file) {
        ArrayList<String> all_data = new ArrayList<>();
        String data;
        try {
            Scanner s = new Scanner(new File(name_of_file));
            while (s.hasNext()) {
                data = s.nextLine();
                all_data.add(data);
            }
            return all_data;
        } catch (IOException e) {

        }
        return null;
    }

    public static void write_to_file(String name, ArrayList<String> data) {
        try {
            FileWriter f = new FileWriter(new File(name));
            BufferedWriter w = new BufferedWriter(f);
            for (String x : data) {
                w.write(x + "\r\n");
            }
            w.close();
        } catch (IOException e) {
            System.out.printf("error : %s" + e);
        }
    }
}

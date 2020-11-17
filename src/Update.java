/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools , Templates
 * and open the template in the editor.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class Update {

    public static void replace() {
        File f = new File("C:\\Assignment-Pro-2\\QBs.dat");
        ArrayList<String> inf = storage("C:\\Assignment-Pro-2\\QBs.dat");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter problem ID: ");
        String d = sc.nextLine();

        try {
            boolean flag = false;
            Scanner input = new Scanner(f);
            String[] sub_data;
            String data;
            StringBuilder Display = new StringBuilder();

            while (input.hasNext()) {
                data = input.nextLine();
                sub_data = data.split(",");
                if (sub_data[0].equals(d)) {
                    Display.append("ProblemID: " + sub_data[0] + "\n" + "Category : " + sub_data[1] + "\n" + "Problem's Short Description: " + sub_data[2] + "\n" + "Link To Full Description: " + sub_data[3] + "\n" + "Problem's Author:" + sub_data[4] + "\n" + "Mark's Weight" + sub_data[5]);
                    flag = true;
                    System.out.println(Display);
                    Scanner s = new Scanner(System.in);
                    String problemId, category, short_description, link, author;
                    double mark_weight;
                    String[] sub_inf;
                    System.out.println("Enter your new ID : ");
                    problemId = s.nextLine();
                    System.out.println("Enter new category : ");
                    category = s.nextLine();
                    System.out.println("Enter new short description : ");
                    short_description = s.nextLine();
                    System.out.println("Enter new link : ");
                    link = s.nextLine();
                    System.out.println("Enter author: ");
                    author = s.nextLine();
                    System.out.println("Enter mark weight: ");
                    mark_weight = s.nextDouble();
                    for (int i = 0; i < inf.size(); i++) {
                        sub_inf = inf.get(i).split(",");

                        if (sub_inf[0].equals(d)) {
                            inf.set(i, problemId + "," + category + "," + short_description + "," + link + "," + author + "," + mark_weight);
                            write_to_file("C:\\Assignment-Pro-2\\QBs.dat", inf);
                            System.out.println("Update successfully");
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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

    public static void remove() {
        ArrayList<String> users = storage("C:\\Assignment-Pro-2\\QBs.dat");
        ArrayList<String> inf = storage("C:\\Assignment-Pro-2\\QBs.dat");
        String[] sub_data_users;
        String[] sub_data_inf;
        for (int i = 0; i < users.size(); i++) {
            sub_data_users = users.get(i).split(",");
            users.remove(i);
            write_to_file("C:\\Assignment-Pro-2\\QBs.dat", users);
        }
        for (int i = 0; i < inf.size(); i++) {
            sub_data_inf = inf.get(i).split(",");
            inf.remove(i);
            write_to_file("C:\\Assignment-Pro-2\\QBs.dat", inf);
        }
    }
}

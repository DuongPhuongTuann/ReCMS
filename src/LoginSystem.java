
import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class LoginSystem {

    private static Scanner x;
    private static Scanner z;

    public static void main(String[] args) {
        System.out.println("======== Contest Management System ========\n");
//        System.out.println("---------------------------------");
//        System.out.println("-----------\tLOGIN SYSTEM\t----------\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter Your Username: ");
        String username = sc.next();
        System.out.print("Please Enter Your Password: ");
        String password = sc.next();
        String filepath = "C:\\Assignment-Pro-2\\coach.dat";
        String filepath2 = "C:\\Assignment-Pro-2\\Information OfCoach.dat";
        LoginSystem(username, password, filepath);

    }

    public static void DisplayInf() {
        File f = new File("C:\\Assignment-Pro-2\\InformationOfCoach.dat");
        try {
            Scanner input = new Scanner(f);
            String[] sub_data;
            String data;
            StringBuilder DisplayInf = new StringBuilder();

            while (input.hasNext()) {
                data = input.nextLine();
                sub_data = data.split(",");
                DisplayInf.append("Id : " + sub_data[0] + "\n" + "Name : " + sub_data[1] + "\n" + "Email : " + sub_data[2] + "\n" + "Phone Number : " + sub_data[3]);
            }
            System.out.println(DisplayInf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void LoginSystem(String username, String password, String filepath) {
        String found = "Your username or password may be incorrect.\nRelogin please.\n ";
        Scanner sc1 = new Scanner(System.in);

        boolean flag = false;
        String tempUsername = "";
        String tempPassword = "";
//        Problem a = new Problem();
//        List b = new List();
        try {
            x = new Scanner(new File(filepath));

            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                tempUsername = x.next();
                tempPassword = x.next();
                if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {
                    found = "Login Successfull";
                    flag = true;
                } else {
                    flag = false;
                }

            }
            x.close();
            System.out.println(found);
            while (flag == true) {
//                
                System.out.println("============================================");
                System.out.println("1-View your Information");
                System.out.println("2-Change your password");
                System.out.println("3-Change your information");
                System.out.println("4-Add a new problem to the Question Bank (QB)");
                System.out.println("5-List all problem");
                System.out.println("6-Update full information for a particular problem by Problem ID");
                System.out.println("7-Generate a new Contest ");
                System.out.println("8-Show the contest's score ");
                System.out.println("0-Exit");
                System.out.println("============================================");
                int choose = sc1.nextInt();
                switch (choose) {
                    case 1:
                        LoginSystem.DisplayInf();
                        break;
                    case 2:
                        LoginSystem.ChangePassword();
                        break;
                    case 3:
                        LoginSystem.ChangeInf();
                        break;
                    case 4:
                        Problem a = new Problem();
                        a.AddProblem();
                        break;
                    case 5:
                        List b = new List();
                        b.Listt();
                        break;
                    case 7:
                        Contest e = new Contest();
                        e.Listttt();
                        break;
                    case 6:
                        Update d = new Update();
                        d.replace();
                        break;
                    case 8:
                        Score f = new Score();
                        f.sco();
                        break;

                    case 0:
                        return;
                }
            }
        } catch (Exception e) {
            System.err.println("Error");

        }
//             Problem a = new Problem();
//             Scanner i = new Scanner(System.in);
//             LoginSystem login =new LoginSystem();
//             int choice = Integer.parseInt(i.nextLine());
//             switch(choice){
//                 case 4:
//                     Problem b = new Problem();
//                     b.AddProblem();
//                 case 1:
//                     login.DisplayInf();
//             }
    }

    public static void ChangePassword() {
        ArrayList<String> users = storage("C:\\Assignment-Pro-2\\coach.dat");
        Scanner s = new Scanner(System.in);
        String[] sub_users;
        System.out.println("Enter you new username : ");
        String username, password;
        username = s.nextLine();
        System.out.println("Enter you new Password : ");
        password = s.nextLine();
        for (int i = 0; i < users.size(); i++) {
            sub_users = users.get(i).split(",");
            users.set(i, username + "," + password);
            write_to_file("C:\\Assignment-Pro-2\\coach.dat", users);
        }
    }

    public static void ChangeInf() {
        ArrayList<String> inf = storage("C:\\Assignment-Pro-2\\InformationOfCoach.dat");
        Scanner s = new Scanner(System.in);
        String coachId, Name, email, phone_number;
        String[] sub_inf;
        System.out.println("Enter you new ID : ");
        coachId = s.nextLine();
        System.out.println("Enter you new Name : ");
        Name = s.nextLine();
        System.out.println("Enter you Email : ");
        email = s.nextLine();
        System.out.println("Enter you phone number : ");
        phone_number = s.nextLine();
        System.out.println("Change your information successfully\n");
        for (int i = 0; i < inf.size(); i++) {
            sub_inf = inf.get(i).split(",");
            inf.set(i, coachId + "," + Name + "," + email + "," + phone_number);
            write_to_file("C:\\Assignment-Pro-2\\InformationOfCoach.dat", inf);
        }
    }

    public LoginSystem() {
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
        ArrayList<String> users = storage("C:\\Assignment-Pro-2\\coach.dat");
        ArrayList<String> inf = storage("C:\\Assignment-Pro-2\\InformationOfCoach.dat");
        String[] sub_data_users;
        String[] sub_data_inf;
        for (int i = 0; i < users.size(); i++) {
            sub_data_users = users.get(i).split(",");
            users.remove(i);
            write_to_file("C:\\Assignment-Pro-2\\coach.dat", users);
        }
        for (int i = 0; i < inf.size(); i++) {
            sub_data_inf = inf.get(i).split(",");
            inf.remove(i);
            write_to_file("C:\\Assignment-Pro-2\\InformationOfCoach.dat", inf);
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

}


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Score {
public static void sco() {
        System.out.println("Please enter user's contest score: ");
        Scanner sco = new Scanner(System.in);
        double userscore = sco.nextDouble();
        File f = new File("C:\\Assignment-Pro-2\\QBz.txt");
        try {
            File x = new File("C:\\Assignment-Pro-2\\Contest_TimeStamp.txt");
    	    Scanner sc = new Scanner(x);
    	    String content = "";
    	    while(sc.hasNextLine()) {
    		  content += sc.nextLine()+"\r\n";
                  
    	  }
  	      System.out.println(content);
              
    	  sc.close();
            Scanner input = new Scanner(f);
            String[] sub_data;
            String data;
            StringBuilder DisplayInf = new StringBuilder();
            double sum =0;
            while (input.hasNext()) {
                data = input.nextLine();
                sub_data = data.split(",");               
                double i = Double.parseDouble(sub_data[5]);
                sum+=i;
            }
            System.out.println("Total maximum score: " +sum);
            System.out.println("User score: " +userscore);
            
            System.out.println("Contest scores after standardization on a 10-point scale: "+userscore/sum*10);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
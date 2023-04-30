package Checkers;
import java.util.Scanner;
public class onlyNumbers {
    static Scanner input = new Scanner(System.in);
    public static int getInt(){
        while (!input.hasNextInt()){
            input.next();
            System.out.println("Just number!");
        }
        int a = input.nextInt();
        return a;
    }
    public static double getDouble(){
        while (!input.hasNextDouble()){
            input.next();
            System.out.println("Just number!");
        }
        double a = input.nextDouble();
        return a;
    }
}

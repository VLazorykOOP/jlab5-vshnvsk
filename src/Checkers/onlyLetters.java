package Checkers;
import java.util.Scanner;
public class onlyLetters {
    static Scanner input = new Scanner(System.in);
    public static String getString(){
        String a = "";
        while (input.hasNextLine()){
            if (input.hasNext("[a-zA-Zа-яА-Я]+")) {
                a = input.nextLine();
                break;
            } else {
                input.next();
                System.out.println("Just letters!");
            }
        }
        return a;
    }
}

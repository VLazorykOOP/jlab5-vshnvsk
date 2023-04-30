package Checkers;
import static Checkers.onlyNumbers.*;
public class positive {
    public static int getPositiveInteger(){
        int positive = -3;
        while(positive < 0){
            positive = getInt();
        }
        return positive;
    }
    public static double getPositiveDouble(){
        double positive = -3;
        while(positive < 0){
            positive = getDouble();
        }
        return positive;
    }
}

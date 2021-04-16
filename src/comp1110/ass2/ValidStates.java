package comp1110.ass2;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ValidStates {
    public static boolean isValidNextPlayer(String in) {
        Predicate pred = x -> x.toString().charAt(0) >= 'A' && x.toString().charAt(0) <= 'D';
        if (pred.test(in))
            return true;
        else
            return false;
    }

   public static ArrayList<String> splitToFactories(String in) {
        ArrayList<String> factories;
        int i=0;

    }

    public static void main(String[] args) {
        String inP1 = "ThisShouldNotWork";
        String inP2 = "DisShouldWork";
        System.out.println(isValidNextPlayer(inP1));
        System.out.println(isValidNextPlayer(inP2));
        System.out.println(inP1.substring(1));
    }
}

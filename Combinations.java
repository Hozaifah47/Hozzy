import java.util.*;

public class Combinations {
    void possibility(String rm, String p) {
        if (rm.length() == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 0; i < rm.length(); i++) {
            char ch = rm.charAt(i);
            String rest = rm.substring(0, i) + rm.substring(i + 1);
            possibility(rest, p + ch);
        }
    }

    class test {

        public static void main(String[] args) {
            Combinations ob = new Combinations();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a word: ");
            String word = sc.nextLine();
            System.out.println("All possible combinations:");

            ob.possibility(word, "");
        }
    }
}
import java.util.*;

public class Sentence2 {
    public static void main(String[] args) {
        String s1, even = "", odd = "";
        int pos, start = 0, count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        s1 = sc.nextLine();
        s1 = s1 + ' ';
        do {
            pos = s1.indexOf(' ', start);
            if (pos == -1) {
                break;
            }

            count++;
            if (count % 2 == 0) {

                even += s1.substring(start, pos) + ' ';
            } else {
                odd += s1.substring(start, pos) + ' ';
            }
            start = pos + 1;
        } while (pos != -1);
        System.out.println(odd);
        System.out.println(even);
    }
}
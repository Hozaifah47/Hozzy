import java.util.*;

public class Sentence {
    public static void main(String[] args) {
        String s1, even = "", odd = "", word;
        int pos, start = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        s1 = sc.nextLine();
        s1 += ' ';

        do {
            pos = s1.indexOf(' ', start);
            if (pos == -1) {
                break;
            }
            word = s1.substring(start, pos);
            int wordLength = word.length();

            if (wordLength % 2 == 0) {
                even += word + ' ';
            } else {
                odd += word + ' ';
            }

            start = pos + 1;
        } while (pos != -1);

        System.out.println(odd);
        System.out.println(even);
    }
}
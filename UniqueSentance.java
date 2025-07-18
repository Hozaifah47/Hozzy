import java.util.*;

class UniqueSentance {
    public static void main(String args[]) {
        String sen;
        char ch;
        int i, j, left = 0, start = 0, length = 0;
        int current;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence");
        sen = sc.nextLine();

        for (i = 0; i < sen.length(); i++) {
            ch = sen.charAt(i);
            for (j = left; j < i; j++) {
                if (sen.charAt(j) == ch) {
                    left = j + 1;
                    break;
                }
            }
            current = i - left + 1;
            if (current > length) {
                length = current;
                start = left;
            }
        }
        System.out.println(sen.substring(start, start + length));

    }
}

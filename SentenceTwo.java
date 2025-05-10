import java.util.*;

class SentenceTwo {
    public static void main(String args[]) {
        SentenceTwo ob = new SentenceTwo();
        String sen;
        int i, c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence");
        sen = sc.nextLine();
        char ch = sen.charAt(sen.length() - 1);
        if (ch != '.' || ch != '!' || ch != '?') {
            System.out.println("Invalid input!");
            return;

        }
        StringTokenizer str = new StringTokenizer(sen, " !.?");
        c = str.countTokens();
        String arr[] = new String[c];
        for (i = 0; i < c; i++) {
            arr[i] = str.nextToken();
            if (ob.isPalindrome(arr[i]) == true) {
                arr[i] = "";

            }
        }

        sen = "";
        for (i = 0; i < c; i++) {
            if (!arr[i].equals("")) {
                sen = sen + arr[i] + ob.getReverse(arr[i]) + ' ';

            }

        }
        System.out.println(sen);

    }

    boolean isPalindrome(String s) {
        int i;
        String s2 = "";
        for (i = 0; i < s.length(); i++) {
            s2 = s.charAt(i) + s2;
        }
        return s2.equals(s);

    }

    String getReverse(String s) {
        int i;
        String rev = "";
        for (i = 0; i < s.length() - 1; i++) {
            rev = s.charAt(i) + rev;

        }
        return rev;
    }

}
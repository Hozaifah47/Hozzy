import java.util.*;

class Occurrence {
    public static void main(String args[]) {

        String sen;
        char ch;
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence");
        sen = sc.nextLine();
        char arr[] = new char[26];
        sen = sen.toUpperCase();
        for (ch = 'A'; ch <= 'Z'; ch++) {
            if (sen.indexOf(ch) != -1) {
                arr[sen.indexOf(ch)] = ch;
            }
        }
        for (i = 0; i < 26; i++) {
            System.out.print(arr[i]);
        }

    }

}
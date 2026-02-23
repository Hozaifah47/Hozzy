import java.util.*;

class OccurWithSpace {
    public static void main(String args[]) {
        String sen;
        char ch;
        int i, space = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence");
        sen = sc.nextLine();
        char arr[] = new char[sen.length()];
        sen = sen.toUpperCase();
        for (ch = 'A'; ch <= 'Z'; ch++) {
            if (sen.indexOf(ch) != -1) {
                arr[sen.indexOf(ch)] = ch;
            }
            if (sen.indexOf(' ', space) != -1) {
                arr[sen.indexOf(' ', space)] = ' ';
                space = space + 1;
            }

        }
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }
}

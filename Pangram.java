import java.util.*;

class Pangram {
    public static void main(String[] args) {

        String sen, smallest, largest;
        int small, large;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence");
        sen = sc.nextLine();

        StringTokenizer str = new StringTokenizer(sen);

        smallest = largest = str.nextToken();
        small = large = smallest.length();

        while (str.hasMoreTokens()) {

            String word = str.nextToken();
            int len = word.length();

            if (len < small) {
                small = len;
                smallest = word;
            }

            if (len > large) {
                large = len;
                largest = word;
            }
        }

        System.out.println("Smallest word: " + smallest);
        System.out.println("Largest word: " + largest);
    }
}
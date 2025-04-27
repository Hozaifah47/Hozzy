import java.util.*;

public class ReverseWordsWithoutSplit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        int start = 0; // Start index of a word
        int length = sentence.length();

        for (int i = 0; i <= length; i++) {
            // Check for a space or the end of the sentence
            if (i == length || sentence.charAt(i) == ' ') {
                // Reverse the current word
                for (int j = i - 1; j >= start; j--) {
                    System.out.print(sentence.charAt(j));
                }
                System.out.println(); // Move to the next line
                start = i + 1; // Update start for the next word
            }
        }
    }
}
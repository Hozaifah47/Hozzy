import java.util.Scanner;

public class WordleMonocrome {
    public static void main(String[] args) {

        String[] words = {
                "apple", "brain", "chair", "dance", "eagle",
                "flame", "ghost", "house", "ivory", "jelly",
                "knock", "light", "money", "night", "ocean",
                "party", "quiet", "river", "snake", "train",
                "unity", "voice", "water", "xerox", "youth",
                "zebra", "brick", "climb", "drill", "earth",
                "faith", "grape", "happy", "index", "judge",
                "knife", "lemon", "magic", "nurse", "orbit",
                "pizza", "queen", "rough", "shine", "tiger",
                "urban", "vivid", "wheat", "yield", "zesty"
        };
        WordleMonocrome ob = new WordleMonocrome();
        byte count = 6;
        String guess, result;
        Scanner sc = new Scanner(System.in);

        System.out.println("You have 6 attempts to guess a secret 5-letter word.");
        System.out.println("With each guess, an text is generated to give you clues:");
        System.out.println("Green: The letter is in the correct spot.");
        System.out.println("Yellow: The letter is in the word but in the wrong spot.");
        System.out.println("If nothing appears the letter is not in the word at all.");
        System.out.println("The game begins !");
        System.out.println("attempts count: " + count);

        String secretWord = words[(int) (Math.random() * words.length)];
        while (count > 0) {
            System.out.print("Enter your guess: ");
            guess = sc.next().toLowerCase();

            if (guess.length() != 5) {
                System.out.println("Invalid input! Please enter a 5-letter word.");
                continue;
            }
            result = ob.getResult(guess, secretWord);
            System.out.println(result);

            if (guess.equals(secretWord)) {
                System.out.println("Congratulations! You have guessed the word.");
                break;
            }

            count--;
            System.out.println("Attempts left: " + count);
        }

        if (count == 0) {
            System.out.println("Sorry! You have run out of attempts. The secret word was: " + secretWord);
        }
    }

    String getResult(String guess, String secret) {
        String result = "";
        boolean[] secretUsed = new boolean[5];
        boolean[] guessUsed = new boolean[5];
        boolean foundMatch;
        char guessChar, secretChar;
        int i;

        for (i = 0; i < 5; i++) {
            guessChar = guess.charAt(i);
            secretChar = secret.charAt(i);

            if (guessChar == secretChar) {
                result += guessChar + " : is Green. ";
                guessUsed[i] = true;
                secretUsed[i] = true;
            }
        }

        for (i = 0; i < 5; i++) {
            if (guessUsed[i])
                continue;

            guessChar = guess.charAt(i);
            foundMatch = false;

            for (int j = 0; j < 5; j++) {
                if (!secretUsed[j] && secret.charAt(j) == guessChar && !guessUsed[i]) {
                    foundMatch = true;
                    secretUsed[j] = true;
                    break;
                }
            }

            if (foundMatch) {
                result += guessChar + " : is Yellow. ";
            }
        }

        return result;
    }
}

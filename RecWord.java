import java.util.*;

public class RecWord {
    public static void main(String[] args) {

        String word;
        GetRecWord ob = new GetRecWord();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word");
        word = sc.nextLine();
        ob.printWord(word, "");

    }

}

class GetRecWord {
    void printWord(String word, String permutation) {
        if (word.length() == 0) {
            System.out.println(permutation);
            return;

        }
        char ch;
        for(int i =0;i<word.length();i++){
            ch= word.charAt(i);
            
        }
        
        printWord(, permutation);

    }
}

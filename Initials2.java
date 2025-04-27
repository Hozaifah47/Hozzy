import java.util.*;

public class Initials2 {

    public static void main(String[] args) {
        String name;
        int start = 0;
        int pos;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name");
        name = sc.nextLine();
        do {
            pos = name.indexOf(' ', start);
            if (name.substring(start, start + 1) != " ") {
                System.out.print(name.substring(start, start + 1) + " ");
            }
            start = pos + 1;
        } while (pos != -1);
    }
}
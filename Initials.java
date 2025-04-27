import java.util.*;

public class Initials {

    public static void main(String[] args) {
        String name;
        int start = 0;
        int pos;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name");
        name = sc.nextLine();
        if (name.indexOf(" ") == -1) {
            System.out.print(name);
        }
        do {
            pos = name.indexOf(' ', start);
            if (name.charAt(start) != ' ') {
                System.out.print(name.charAt(start) + " ");
            }
            start = pos + 1;
        } while (pos != name.lastIndexOf(' '));
        System.out.print(name.substring(pos, name.length()));
    }
}
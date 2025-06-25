import java.util.*;

public class RevRecString {
    public static void main(String[] args) {

        rev ob = new rev();

        String str;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence");
        str = sc.nextLine();
        System.out.println(ob.getReverse(str));

    }

}

class rev {

    String getReverse(String str) {
        if (str.equals("")) {
            return str;
        }
        return getReverse(str.substring(1)) + str.charAt(0);
    }

}

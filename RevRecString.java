import java.util.*;

public class RevRecString {
    public static void main(String[] args) {

        rev ob = new rev();
        Exponents jk = new Exponents();
        Binary dc = new Binary();
        String str;
        int a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence");
        str = sc.nextLine();
        System.out.println(ob.getReverse(str));
        System.out.println("enter a ,b");
        a = sc.nextInt();
        b = sc.nextInt();
        jk.getExponents(a, b);
        System.out.println(dc.getBinary(a));

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

class Exponents {
    int getExponents(int a, int b) {
        if (b == 0) {
            return 1;
        }
        return a * getExponents(a, b - 1);
    }
}
// gcd of 2 num deci bi find max replace a with x in a string remove dupes from
// string print or subsets of a string sum of elements in an array

class Binary {
    String getBinary(int n) {
        if (n == 0) {
            return "";
        }
        return getBinary(n / 2) + (n % 2);
    }
}
import java.util.*;

public class FactorsRec {
    static int num;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to get its factors");
        num = sc.nextInt();
        System.out.println(sumOfFactors(num));
        System.out.println("2nd " + sumOfFactors2(num, num));

    }

    static int sumOfFactors(int n) {
        if (n == 0)
            return 0;

        int sum = sumOfFactors(n - 1);
        if (num % n == 0)
            sum += n;

        return sum;

    }

    static int sumOfFactors2(int n, int i) {
        if (i == 0)
            return 0;

        if (n % i == 0)
            return i + sumOfFactors2(n, i - 1);
        return sumOfFactors2(n, i - 1);
    }
}

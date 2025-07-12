import java.util.*;

public class BalancingNum {
    public static void main(String[] args) {

        int num, i;
        BalancingNum ob = new BalancingNum();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");

        num = sc.nextInt();
        if (ob.isBalnum(num)) {
            System.out.println("The number is balancing");
        } else {
            System.out.println("Number is not Balancing");
        }

        for (i = 1; i <= 1000000; i++) {
            if (ob.isBalnum(i)) {
                System.out.println(i);
            }
        }

    }

    boolean isBalnum(int num) {
        int left, right = 0, adder = num + 1;
        left = (num * (num - 1)) / 2;
        while (right <= left) {
            if (right == left) {
                return true;
            }
            right = right + adder;
            adder += 1;

        }
        return false;
    }

}

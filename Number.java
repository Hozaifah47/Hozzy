import java.util.*;

class Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int num = sc.nextInt();
        int c = 0;
        int temp = num;
        while (temp != 0) {
            temp /= 10;
            c++;
        }
        int second;
        second = (int) (num / Math.pow(10, c - 2));
        second = second % 10;
        second = (int) (second * (Math.pow(10, c - 2)));
        num = num - second;
        System.out.println(num);
    }
}
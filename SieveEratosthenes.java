import java.util.*;

public class SieveEratosthenes {
    public static void main(String args[]) {
        int i, j, num, value = 2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the last number");
        num = sc.nextInt();
        sc.close();
        if (num < 2) {
            System.out.println("Invalid Input !");
            return;
        }

        int arr[] = new int[num - 1];
        for (i = 0; i < num - 1; i++) {
            arr[i] = value;
            value++;
        }
        for (i = 0; i < (int) Math.sqrt(num - 1); i++) {
            if (arr[i] == 0)
                continue;

            for (j = i + 1; j < num - 1; j++) {
                if (arr[j] != 0 && arr[j] % arr[i] == 0) {
                    arr[j] = 0;
                }

            }
        }
        System.out.println("All prime numbers between 1 and " + num);
        for (i = 0; i < num - 1; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
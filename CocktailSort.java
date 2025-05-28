import java.util.*;

class CocktailSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, beg = 0, flag = 1, temp;
        int a[] = new int[5];
        int end = a.length - 1;

        for (i = 0; i < 5; i++) {
            System.out.println("Enter number:");
            a[i] = sc.nextInt();
        }

        while (flag == 1) {
            flag = 0;

            // Forward pass
            for (i = beg; i < end; i++) {
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    flag = 1;
                }
            }

            if (flag == 0)
                break;

            flag = 0;
            end--;

            // Backward pass
            for (i = end; i > beg; i--) {
                if (a[i] < a[i - 1]) {
                    temp = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = temp;
                    flag = 1;
                }
            }
            beg++;
        }

        System.out.println("Sorted array:");
        for (i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        sc.close();
    }
}
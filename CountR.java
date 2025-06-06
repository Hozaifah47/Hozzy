import java.util.*;

public class CountR {
    public static void main(String args[]) {
        int size, i, index = 0, value = 1;
        int[] count = new int[101];
        // sort for only elements ranging from 1-100

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array :");
        size = sc.nextInt();
        int arr[] = new int[size];
        for (i = 0; i < size; i++) {
            System.out.println("Enter a number (count: " + (i + 1) + ")");
            arr[i] = sc.nextInt();
        }

        i = 0;

        while (i < size || index < size) {
            if (i < size) {
                count[arr[i]]++;
                i++;
            } else if (value < 101 && count[value] > 0) {
                arr[index++] = value;
                count[value]--;
            } else {
                value++;
            }
        }
        System.out.println("Sorted array!");
        for (i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }

    }

}

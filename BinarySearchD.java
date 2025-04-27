import java.util.*;

public class BinarySearchD {
    public static void main(String[] args) {
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size");
        int size = sc.nextInt();
        int arr[] = new int[size];
        for (i = 0; i < size; i++) {
            System.out.println("Enter a number (count: " + i + ")");
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the number to be searched");
        int search = sc.nextInt();
        sc.close();
        for (i = 0; i < size - 1; i++) {
            for (int j = i; j < size; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;

                }
            }
        }
        int start = 0, end = arr.length - 1, mid, pos = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (search > arr[mid]) {
                end = mid - 1;
            } else if (search < arr[mid]) {
                start = mid + 1;
            } else {
                pos = mid;
                break;
            }
        }
        System.out.println("Index of " + search + ": " + pos);
        System.out.println("Sorted array");

        for (i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }
}
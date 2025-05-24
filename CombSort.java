import java.util.*;

class CombSort {
    public static void main(String[] args) {

        int size, i;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array :");
        size = sc.nextInt();
        int arr[] = new int[size];
        for (i = 0; i < size; i++) {
            System.out.println("Enter a number (count: " + (i + 1) + ")");
            arr[i] = sc.nextInt();
        }

    }

}

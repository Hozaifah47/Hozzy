import java.util.*;

class CombSort {
    public static void main(String[] args) {

        int size, gap, i;
        boolean check = true;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array :");
        size = sc.nextInt();
        int arr[] = new int[size];
        for (i = 0; i < size; i++) {
            System.out.println("Enter a number (count: " + (i + 1) + ")");
            arr[i] = sc.nextInt();
        }
        gap = size;

        while (gap > 1 || check) {
            gap = (int) (gap / 1.3);
            if (gap < 1) {
                gap = 1;
            }

            check = false;
            for (i = 0; i + gap < arr.length; i++) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    check = true;
                }

            }

        }

    }

}

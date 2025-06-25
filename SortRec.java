import java.util.*;

class SortRec {
    public static void main(String[] args) {
        sort ob = new sort();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ob.accendSort(arr, arr.length, 0);

    }
}

class sort {
    void accendSort(int[] arr, int len, int i) {

        if (len == 1) {
            arrayPrinter(arr);

            return;
        }
        if (i == len - 1) {
            accendSort(arr, len - 1, 0);

            return;
        }

        if (arr[i] > arr[i + 1]) {
            arr[i] = arr[i] + arr[i + 1];
            arr[i + 1] = arr[i] - arr[i + 1];
            arr[i] = arr[i] - arr[i + 1];
        }

        accendSort(arr, len, i + 1);
    }

    void arrayPrinter(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}

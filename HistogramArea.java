import java.util.*;

public class HistogramArea {
    public static void main(String args[]) {

        int size, i, highest = 0, area = 0, j, current, k;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of class intervals");
        size = sc.nextInt();

        int arr[] = new int[size];

        for (i = 0; i < size; i++) {
            System.out.println("Enter the frequency");
            arr[i] = sc.nextInt();
        }

        int temp[] = new int[size];

        for (i = 0; i < size; i++) {
            temp[i] = arr[i];
            if (arr[i] > highest) {
                highest = arr[i];
            }
        }

        for (i = 0; i < highest; i++) {

            current = 0;

            for (j = 0; j < size; j++) {

                if (temp[j] != 0) {
                    current++;
                } else {

                    int levelHeight = i + 1;
                    int calculatedArea = current * levelHeight;

                    if (calculatedArea > area) {
                        area = calculatedArea;
                    }

                    current = 0;
                }
            }

            int levelHeight = i + 1;
            int calculatedArea = current * levelHeight;

            if (calculatedArea > area) {
                area = calculatedArea;
            }

            for (k = 0; k < size; k++) {
                if (temp[k] != 0) {
                    temp[k] = temp[k] - 1;
                }
            }
        }

        System.out.println("Maximum Area = " + area);
    }
}

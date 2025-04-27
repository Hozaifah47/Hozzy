import java.util.*;

public class MatrixSum {
    public static void main(String[] args) {
        int i, j;
        int[][] arr = new int[3][4];
        int[][] arr2 = new int[3][4];
        int[][] sum = new int[3][4];
        Scanner sc = new Scanner(System.in);
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                System.out.println("Enter a number for the 1st matrix row: " + (i + 1) + " and column: " + (j + 1));
                arr[i][j] = sc.nextInt();
                System.out.println("Enter a number for the 2nd matrix row: " + (i + 1) + " and column: " + (j + 1));
                arr2[i][j] = sc.nextInt();
                sum[i][j] = arr[i][j] + arr2[i][j];
            }
        }
        System.out.println("Sum of both matrices");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                System.out.print(sum[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
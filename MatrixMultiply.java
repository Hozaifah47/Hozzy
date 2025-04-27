import java.util.*;

public class MatrixMultiply {
    public static void main(String[] args) {
        int i, j, h, row, col, row1, col1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a the number of rows");
        row = sc.nextInt();
        System.out.println("Enter the number of columns");
        col = sc.nextInt();
        System.out.println("Enter a the number of rows");
        row1 = sc.nextInt();
        System.out.println("Enter the number of columns");
        col1 = sc.nextInt();
        if (col != row1) {
            System.out.println("They are not compatible");
            sc.close();
            return;
        }
        int[][] arr = new int[row][col];
        int[][] arr1 = new int[row1][col1];
        int[][] product = new int[row][col1];

        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                System.out.println("Enter a number for 1st matrix row: " + (i + 1) + " and column: " + (j + 1));
                arr[i][j] = sc.nextInt();

            }
        }
        for (i = 0; i < row1; i++) {
            for (j = 0; j < col1; j++) {
                System.out.println("Enter a number for for 2nd matrix row: " + (i + 1) + " and column: " + (j + 1));
                arr1[i][j] = sc.nextInt();
            }
        }
        for (i = 0; i < row; i++) {
            for (j = 0; j < col1; j++) {
                for (h = 0; h < col; h++) {
                    product[i][j] += arr[i][h] * arr1[h][j];
                }

            }
        }
        System.out.println("The product of matrices is:");
        for (i = 0; i < row; i++) {
            for (j = 0; j < col1; j++) {
                System.out.print(product[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
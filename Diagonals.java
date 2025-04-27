import java.util.*;

public class Diagonals {
    public static void main(String[] args) {
        int i, j, dsum = 0;
        int[][] arr = new int[4][4];
        Scanner sc = new Scanner(System.in);
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                System.out.println("Enter a number for row: " + (i + 1) + " and column: " + (j + 1));
                arr[i][j] = sc.nextInt();
            }
        }
        for (i = 0; i < 4; i++) {
            dsum += arr[i][i];
        }
        System.out.println("primary diagonal " + dsum);
        dsum = 0;
        for (i = 0; i < 4; i++) {
            dsum += arr[i][3 - i];
        }
        System.out.println("secondary diagonal " + dsum);
    }
}
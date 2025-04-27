import java.util.*;

class kaprekar {
    static int digit[] = new int[4];

    public static int doKaprekar(int n) {
        int i = 3, tmp, des = 0, temp, asc = 0;
        tmp = n;
        while (i >= 0)// extract digits
        {
            digit[i] = tmp % 10;
            tmp /= 10;
            i--;
        }
        for (i = 0; i < 3; i++)// bubble sort
        {
            for (int j = 0; j < 4 - i - 1; j++) {
                if (digit[j] < digit[j + 1]) {
                    temp = digit[j];
                    digit[j] = digit[j + 1];
                    digit[j + 1] = temp;
                }
            }
        }
        i = 0;
        while (i < 4)// descending order
        {
            des = des + digit[i] * (int) Math.pow(10, 3 - i);
            i++;
        }
        i = 3;
        while (i >= 0)// ascending order
        {
            asc = asc + digit[i] * (int) Math.pow(10, i);
            i--;
        }
        return des - asc;
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n, temp, i = 1;
        System.out.println("enter a 4 digit number");
        n = sc.nextInt();
        temp = n;
        while (temp != 6174) {
            temp = doKaprekar(temp);
            i++;
        }
        System.out.println("kaprekar constant found after " + i + " iterations");
    }
}
import java.util.*;

class FacinatingNum {
    public boolean isUnique(int num) {
        int d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5 = 0, d6 = 0, d7 = 0, d8 = 0, d9 = 0;

        while (num > 0) {
            if (num % 10 == 0) {
                return false;
            }
            switch (num % 10) {
                case 1:
                    d1 += 1;
                    break;

                case 2:
                    d2 += 1;
                    break;

                case 3:
                    d3 += 1;
                    break;

                case 4:
                    d4 += 1;
                    break;

                case 5:
                    d5 += 1;
                    break;

                case 6:
                    d6 += 1;
                    break;

                case 7:
                    d7 += 1;
                    break;

                case 8:
                    d8 += 1;
                    break;

                case 9:
                    d9 += 1;
                    break;
            }
            num /= 10;
        }
        if (d1 == 1 && d2 == 1 && d3 == 1 && d4 == 1 && d5 == 1
                && d6 == 1 && d7 == 1 && d8 == 1 && d9 == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public boolean isFacinating(int num) {
        int two = num * 2;
        int three = num * 3;
        int p1 = countDigits(two);
        int p2 = countDigits(three);
        int facinating = ((int) Math.pow(10, p1) * num) + two;
        facinating = ((int) Math.pow(10, p2) * facinating) + three;
        if (isUnique(facinating)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        int num;
        FacinatingNum ob = new FacinatingNum();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        num = sc.nextInt();
        if (ob.isFacinating(num)) {
            System.out.println("the number is facinating");
        } else {
            System.out.println("The number is not facinating");
        }
    }
}
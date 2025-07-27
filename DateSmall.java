import java.util.*;

class DateSmall {

    public static void main(String args[]) {

        String date1, date2, date3, date4;
        ;
        int result;
        DateSmall ob = new DateSmall();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first date of first range (Format : DD/MM/YYYY)");
        date1 = sc.nextLine();
        System.out.println("Enter the second date of first range (Format : DD/MM/YYYY)");
        date2 = sc.nextLine();
        System.out.println("Enter the first date of second range (Format : DD/MM/YYYY)");
        date3 = sc.nextLine();
        System.out.println("Enter the second date of second range (Format : DD/MM/YYYY)");
        date4 = sc.nextLine();

        int[] d1 = ob.isValidDate(date1);
        int[] d2 = ob.isValidDate(date2);
        int[] d3 = ob.isValidDate(date3);
        int[] d4 = ob.isValidDate(date4);

        if (d1[0] == 0 || d2[0] == 0 || d3[0] == 0 || d4[0] == 0) {

            System.out.println("Invalid input!");
            return;
        }

    }

    int[] isValidDate(String a) {

        int pos;
        int days[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        pos = a.indexOf('/');
        if (pos == -1 || a.indexOf('/', pos + 1) == -1 || a.indexOf('/', a.indexOf('/', pos + 1) + 1) != -1) {
            return new int[] { 0 };
        }
        int date[] = { Integer.parseInt(a.substring(0, pos)),
                Integer.parseInt(a.substring(pos + 1, a.indexOf('/', pos + 1))),
                Integer.parseInt(a.substring(a.indexOf('/', pos + 1) + 1, a.length())) };

        if (date[2] < 1) {

            return new int[] { 0 };

        }
        if (date[1] < 1 || date[1] > 12) {

            return new int[] { 0 };
        }
        if (date[1] == 2) {
            if ((date[2] % 4 == 0 && date[2] % 100 != 0) || (date[2] % 400 == 0)) {
                days[2] = 29;
            }

        }
        if (date[0] < 1 || date[0] > days[date[1]]) {
            return new int[] { 0 };
        }
        if (date[2] == 1592 && date[1] == 10 && (date[0] > 3 && date[0] < 15)) {
            return new int[] { 0 };

        }

        return date;

    }

    int isSmaller(int d1[], int d2[]) {

        if (d1[2] < d2[2]) {
            return -1;
        }
        if (d1[2] == d2[2]) {
            if (d1[1] < d2[1]) {
                return -1;
            }
            if (d1[1] == d2[1]) {
                if (d1[0] < d2[0]) {
                    return -1;
                }
                if (d1[0] == d2[0]) {
                    return 0;
                }
            }
        }

        return 1;

    }

}
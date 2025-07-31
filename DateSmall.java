import java.util.*;

class DateSmall {

    public static void main(String args[]) {
        String date1, date2, date3, date4;
        int[] d1, d2, d3, d4;

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

        try {
            d1 = ob.isValidDate(date1);
            d2 = ob.isValidDate(date2);
            d3 = ob.isValidDate(date3);
            d4 = ob.isValidDate(date4);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        if (ob.isSmaller(d1, d2) == 1 || ob.isSmaller(d3, d4) == 1) {

            System.out.println("first date of a range cant be bigger then the second date");

        }
        if (ob.isOverlap(d1, d2, d3, d4)) {

            System.out.println("The dates are overlaping");

        }

    }

    int[] isValidDate(String a) throws Exception {
        int pos;
        int days[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        pos = a.indexOf('/');

        if (pos == -1 || a.indexOf('/', pos + 1) == -1 || a.indexOf('/', a.indexOf('/', pos + 1) + 1) != -1) {
            throw new Exception("Invalid format: Must be DD/MM/YYYY");
        }

        int date[];
        try {
            date = new int[] {
                    Integer.parseInt(a.substring(0, pos)),
                    Integer.parseInt(a.substring(pos + 1, a.indexOf('/', pos + 1))),
                    Integer.parseInt(a.substring(a.indexOf('/', pos + 1) + 1))
            };
        } catch (Exception e) {
            throw new Exception("Invalid number parsing: " + e.getMessage());
        }

        if (date[2] < 1)
            throw new Exception("Year must be >= 1");
        if (date[1] < 1 || date[1] > 12)
            throw new Exception("Month must be between 1 and 12");

        if (date[1] == 2 && ((date[2] % 4 == 0 && date[2] % 100 != 0) || (date[2] % 400 == 0))) {
            days[2] = 29;
        }

        if (date[0] < 1 || date[0] > days[date[1]])
            throw new Exception("Day is out of range for given month and year");

        if (date[2] == 1592 && date[1] == 10 && (date[0] > 3 && date[0] < 15))
            throw new Exception("Date falls in the skipped range of Gregorian calendar");

        return date;
    }

    int isSmaller(int d1[], int d2[]) {
        if (d1[2] < d2[2])
            return -1;
        if (d1[2] == d2[2]) {
            if (d1[1] < d2[1])
                return -1;
            if (d1[1] == d2[1]) {
                if (d1[0] < d2[0])
                    return -1;
                if (d1[0] == d2[0])
                    return 0;
            }
        }
        return 1;
    }

    boolean isOverlap(int start1[], int end1[], int start2[], int end2[]) {
        return !(isSmaller(end1, start2) == -1 || isSmaller(end2, start1) == -1);
    }
}

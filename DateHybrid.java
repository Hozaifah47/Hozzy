import java.util.*;

class DateHybrid {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int days[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // start day , end day , end month , start month

        int sd1, sm1, ed1, em1, sd2, sm2, ed2, em2;
        int day = 0, i;
        boolean flag = false;

        // first range

        System.out.println("For the range of the 1st date");
        System.out.println("Enter the month");
        sm1 = sc.nextInt();
        if (sm1 < 1 || sm1 > 12) {
            System.out.println("Invalid Input !");
            return;
        }
        System.out.println("Enter the day");
        sd1 = sc.nextInt();
        if (sd1 < 1 || sd1 > days[sm1]) {
            System.out.println("Invalid Input !");
            return;
        }
        System.out.println("Enter the month");
        em1 = sc.nextInt();
        if (em1 < 1 || em1 > 12) {
            System.out.println("Invalid Input !");
            return;
        }
        System.out.println("Enter the day");
        ed1 = sc.nextInt();
        if (ed1 < 1 || ed1 > days[em1]) {
            System.out.println("Invalid Input !");
            return;
        }

        // check for valid first range

        if (sm1 > em1 || (sm1 == em1 && ed1 <= sd1)) {
            System.out.println("Enter the values correctly!");
            return;
        }

        // second range

        System.out.println("For the range of the 2nd date");
        System.out.println("Enter the month");
        sm2 = sc.nextInt();
        if (sm2 < 1 || sm2 > 12) {
            System.out.println("Invalid Input !");
            return;
        }
        System.out.println("Enter the day");
        sd2 = sc.nextInt();
        if (sd2 < 1 || sd2 > days[sm2]) {
            System.out.println("Invalid Input !");
            return;
        }
        System.out.println("Enter the month");
        em2 = sc.nextInt();
        if (em2 < 1 || em2 > 12) {
            System.out.println("Invalid Input !");
            return;
        }
        System.out.println("Enter the day");
        ed2 = sc.nextInt();
        if (ed2 < 1 || ed2 > days[em2]) {
            System.out.println("Invalid Input !");
            return;
        }

        // check for valid second range

        if (sm2 > em2 || (sm2 == em2 && ed2 <= sd2)) {
            System.out.println("Enter the values correctly!");
            return;
        }

        // special case where there is same month for all dates

        if (sm1 == em1 && sm2 == em2 && sm1 == sm2) {
            if (ed1 <= sd1 || ed2 <= sd2) {
                System.out.println("Enter the values correctly!");
                return;
            }
        }

        // now checking if intersecting or not

        if (sm2 < em1) {
            flag = true;
        }
        if (sm2 == em1 && sd2 < ed1) {
            flag = true;
        }
        if ((sm1 == em1 && sm2 == em2 && sm1 == sm2) && (sd2 < ed1)) {
            flag = true;
        }

        if (flag == true) {
            System.out.println("intersecting");
        } else {
            System.out.println("not intersecting");
            return;
        }

        // calculating the days in between

        if ((sm1 == em1 && sm2 == em2 && sm1 == sm2) || (em1 == sm2)) {
            day = ed1 - sd2;
        } else {
            day = days[sm2] - sd2;
            for (i = sm2 + 1; i < em1; i++) {
                day += days[i];
            }
            day += ed1;
        }
        System.out.println("number of days in between : " + day);
    }
}

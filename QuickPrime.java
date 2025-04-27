
public class QuickPrime

{
    static int c = 0;

    public static void main(String[] args) {
        int i;
        QuickPrime ob = new QuickPrime();
        for (i = 1000000; i <= 10000000; i++) {
            c++;
            if (i % 3 == 0 || i % 2 == 0) {
                c++;
                continue;
            }
            if ((i % 6 == 5 || i % 6 == 1) && ob.isPrime(i) == true) {
                c++;
                System.out.println(i);
            }
        }
        System.out.println("steps taken " + c);
    }

    boolean isPrime(int num) {
        for (int i = 5; i <= (int) Math.sqrt(num); i += 6) {
            c++;
            if (num % i == 0 || num % (i + 2) == 0) {
                c++;
                return false;
            }
        }
        return true;
    }
}
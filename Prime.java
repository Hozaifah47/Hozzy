
public class Prime {
    static int c = 0;

    public static void main(String[] args) {
        int i;
        Prime ob = new Prime();
        for (i = 1000000; i <= 10000000; i++) {
            c++;
            if (ob.isPrime(i) == true) {
                c++;
                System.out.println(i);
            }
        }
        System.out.println("steps : " + c);
    }

    boolean isPrime(int num) {
        for (int i = 2; i < (int) Math.sqrt(num); i++) {
            c++;
            if (num % i == 0) {
                c++;
                return false;
            }
        }

        return true;

    }
}
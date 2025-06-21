import java.util.*;

class PrimeRec {
    public static void main(String[] args) {
        int num;
        PrimeRec ob = new PrimeRec();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        num = sc.nextInt();
        ob.primeFactorize(num, 2);

    }

    void primeFactorize(int n, int i) {
        if (n == 1)
            return;

        if (n % i == 0) {
            System.out.print(i + " ");
            primeFactorize(n / i, i);
        } else {
            primeFactorize(n, i + 1);
        }
    }

}

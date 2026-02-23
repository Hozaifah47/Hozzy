
public class Smith {
    public boolean isSmith(int num) {
        return getSumOfDigits(num) == sumOfPrimeFactors(num);
    }

    public int getSumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;

        }
        return sum;
    }

    public int sumOfPrimeFactors(int num) {
        int sum = 0, prime = 3;
        while (num % 2 == 0) {
            sum += 2;
            num /= 2;
        }
        while (num != 1) {
            if (isPrime(prime)) {
                while (num % prime == 0) {
                    sum += prime;
                    num /= prime;
                }
            } else {
                prime++;
            }

        }
        return sum;
    }

    boolean isPrime(int num) {
        int c = 0, i;
        for (i = 2; i < (int) Math.sqrt(num); i++) {
            c++;
            if (num % i == 0) {
                c++;
                return false;
            }
        }

        return true;

    }

}

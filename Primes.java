import java.util.*;

class Primes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Declare variables to store input range and counters
        int min, max, n, a, i;

        // Prompt user and read the minimum value of the range
        System.out.print("Enter min : ");
        min = sc.nextInt();

        // Prompt user and read the maximum value of the range
        System.out.print("Enter max : ");
        max = sc.nextInt();

        // Calculate n = floor((min+1)/6) to start checking primes from 6n-1 near min
        n = (int) Math.floor((min + 1) / 6d);
        System.out.println("N " + n);

        // Calculate the first candidate number of the form 6n - 1 >= min
        a = 6 * n - 1;

        // Print 2 if it lies within the range since it's a prime not covered by 6k ± 1
        // form
        if (2 >= min && 2 <= max)
            System.out.println(2);

        // Print 3 if it lies within the range, same reason as 2
        if (3 >= min && 3 <= max)
            System.out.println(3);

        // Iterate through numbers of the form 6k ± 1 from a up to max
        for (i = a; i <= max; i += 6) {
            // Check if i (6k - 1) is in range and prime, then print it
            if (i >= min && isPrime(i))
                System.out.println(i);

            // Check if i+2 (6k + 1) is in range and prime, then print it
            if (i + 2 <= max && isPrime(i + 2))
                System.out.println(i + 2);
        }
    }

    // Method to check if a number is prime using 6k ± 1 optimization
    public static boolean isPrime(int num) {
        // 1 is not prime
        if (num == 1)
            return false;

        // Check divisibility starting from 5, increment by 6 each iteration
        // Only check divisors of form 6k ± 1 up to sqrt(num)
        for (int i = 5; i * i <= num; i += 6) {
            // If divisible by i or i+2, number is not prime
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        }

        // If no divisors found, number is prime
        return true;
    }
}

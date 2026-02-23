
public class FormNum {
    public int formNumber(int num) {
        int odd = 0, even = 0;
        int oddMul = 1, evenMul = 1;
        int pos = 1;

        while (num > 0) {
            int digit = num % 10;

            if (pos % 2 == 1) {
                odd = digit * oddMul + odd;
                oddMul *= 10;
            } else {
                even = digit * evenMul + even;
                evenMul *= 10;
            }

            num /= 10;
            pos++;
        }

        return odd * evenMul + even;
    }

}

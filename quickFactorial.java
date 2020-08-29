/* *****************************************************************************
 *  Name:              xnpipi
 *  Last modified:     29/8/2020
 **************************************************************************** */

public class quickFactorial {
    private quickFactorial() {
    }

    private static final int[] f1 = { 1, 1, 2, 6, 4, 2, 2, 4, 2, 8 };
    private static final int[] f2 = { 8, 4, 2, 6 };

    //return how many 9!
    private static long qFSum(long n) {
        if (n <= 0) throw new IllegalArgumentException("input can not be NaN");
        long sum = 0;
        while (n > 0) {
            sum += n / 10;
            n /= 10;
        }
        return sum;
    }


    private static long qFmulti(long n) {
        if (n <= 0) throw new IllegalArgumentException("input can not be NaN");
        long sum = 1;
        while (n > 0) {
            sum *= f1[(int) (n % 10)];
            n /= 10;
        }
        return sum;
    }

    public static long qF(long n) {
        long result;
        if (qFSum(n) == 0) {
            result = toOne(qFmulti(n));
            return result;
        }
        result = qFmulti(n) * f2[(int) ((qFSum(n) - 1) % 4)];
        result = toOne(result);
        return result;
    }

    private static long toOne(long n) {
        while (n >= 10 && n % 10 == 0) {
            n /= 10;
        }
        return n % 10;
    }

    public static void main(String[] args) {
        long x = Long.parseLong(args[0]);
        StdOut.println(qF(x));
    }
}

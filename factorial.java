/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class factorial {
    private factorial() {
    }

    private static long toOne(long n) {
        while (n >= 10 && n % 10 == 0) {
            n /= 10;
        }
        return n % 10;
    }

    public static long actorial(long n) {
        long sum = 1;
        for (long i = 1; i <= n; i++) {
            sum *= toOne(i);
            while (sum > 100000 && sum % 10 == 0) {
                sum /= 10;
            }
            sum %= 100000;
        }
        StdOut.print(sum + " ");
        return toOne(sum);
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(actorial(n));
    }
}

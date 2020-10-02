/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class findPrimeNumbers {


    public static void main(String[] args) {
        Queue<Double> primeNumbers;
        primeNumbers = new Queue<Double>();
        double e = 2;
        primeNumbers.enqueue(e);
        for (double x = 2; x < Double.POSITIVE_INFINITY; x++) {
            if (isPrimeNumber(x, primeNumbers)) {
                primeNumbers.enqueue(x);
                float size = primeNumbers.size();
                float rate = (float) (size / x);
                StdOut.println(x + "    " + rate);
            }
        }

    }

    private static boolean isPrimeNumber(double x, Queue<Double> primeNumbers) {
        for (double i : primeNumbers) {
            if (x % i == 0) return false;
        }
        return true;
    }
}

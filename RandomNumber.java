/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */


import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i = 1; i < n; i++) {
            Random r = new Random();
            int num = r.nextInt(100);
            System.out.println(num);
        }


    }
}



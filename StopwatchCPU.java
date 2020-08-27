/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;


public class StopwatchCPU {
    private static final double NANOSECONDS_PRE_SECOND = 1000000000;

    private final ThreadMXBean threadTimer;
    private final long start;

    public StopwatchCPU() {
        threadTimer = ManagementFactory.getThreadMXBean();
        start = threadTimer.getCurrentThreadCpuTime();
    }

    public double elapsedTime() {
        long now = threadTimer.getCurrentThreadCpuTime();
        return (now - start) / NANOSECONDS_PRE_SECOND;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        StopwatchCPU timer1 = new StopwatchCPU();
        double sum1 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum1 += Math.sqrt(i);
        }
        double time1 = timer1.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum1, time1);
        StopwatchCPU timer2 = new StopwatchCPU();
        double sum2 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum2 += Math.sqrt(i);
        }
        double time2 = timer2.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum2, time2);

    }
}

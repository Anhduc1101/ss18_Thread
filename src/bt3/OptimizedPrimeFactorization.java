package bt3;

import java.util.Date;

public class OptimizedPrimeFactorization implements Runnable {
    private volatile boolean isRunning = true;

    public OptimizedPrimeFactorization(int stopValue) {
        this.stopValue = stopValue;
    }

    private int stopValue;

    @Override
    public void run() {
        int n = 2;
        while (isRunning&&n<=stopValue) {
            if (isPrime(n)) {
                System.out.println("OptimizedPrimeFactorization number: " + n +", time: "+ System.currentTimeMillis()+" ms");

            }
            n++;
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n) + 1;
        for (int i = 6; i < sqrt; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }

    public void stopRunning() {
        isRunning = false;
    }
}

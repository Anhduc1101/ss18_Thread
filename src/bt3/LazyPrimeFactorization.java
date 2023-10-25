package bt3;

public class LazyPrimeFactorization implements Runnable {
    private volatile boolean isRunning = true;
    private int stopValue;

    public LazyPrimeFactorization(int stopValue) {
        this.stopValue = stopValue;
    }

    @Override
    public void run() {
        int n = 2;
        while (isRunning&&n<=stopValue) {
            if (isPrime(n)) {
                System.out.println("LazyPrimeFactorization number: " + n + ", time: "+System.currentTimeMillis()+" ms");
            }
            n++;
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void stopRunning() {
        isRunning = false;
    }
}

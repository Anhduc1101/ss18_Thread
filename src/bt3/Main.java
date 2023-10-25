package bt3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int stopValue = Integer.parseInt(scanner.nextLine());
        LazyPrimeFactorization lazyPrimeFactorization = new LazyPrimeFactorization(stopValue);
        OptimizedPrimeFactorization optimizedPrimeFactorization = new OptimizedPrimeFactorization(stopValue);
        Thread thread1 = new Thread(lazyPrimeFactorization);
        Thread thread2 = new Thread(optimizedPrimeFactorization);

        thread1.start();
        thread2.start();
        try {
            thread1.sleep(50);
//            thread2.join();
            thread2.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lazyPrimeFactorization.stopRunning();
        optimizedPrimeFactorization.stopRunning();
        scanner.close();

    }
}

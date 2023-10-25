package bt2;

public class EvenThread extends Thread {
    public void run() {
        System.out.println("EvenThread");
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

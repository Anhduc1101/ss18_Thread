package bt2;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();
        oddThread.start();
        evenThread.join();
        evenThread.start();
    }
}

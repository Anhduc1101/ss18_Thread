package bt1;

public class NumberGenerator implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        NumberGenerator numberGenerator1=new NumberGenerator();
        NumberGenerator numberGenerator2=new NumberGenerator();
        Thread thread1=new Thread(numberGenerator1);
        Thread thread2=new Thread(numberGenerator2);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread"+Thread.currentThread().getName()+", number: "+i+", hashcode"+this.hashCode());
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

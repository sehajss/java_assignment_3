class EvenNumberThread extends Thread {
    @Override
    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.println(i);
            try {
                Thread.sleep(500); // 500ms delay
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e);
            }
        }
    }
}

public class EvenThreadDemo {
    public static void main(String[] args) {
        EvenNumberThread t = new EvenNumberThread();
        t.start(); // Start the thread
    }
}


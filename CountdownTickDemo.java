class CountdownThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 10; i >= 1; i--) {
                System.out.println("Countdown: " + i);
                Thread.sleep(1000); // 1 second delay
            }
        } catch (InterruptedException e) {
            System.out.println("Countdown thread interrupted: " + e);
        }
    }
}

class TickThread extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Tick...");
                Thread.sleep(500); // 0.5 second delay
            }
        } catch (InterruptedException e) {
            System.out.println("Tick thread interrupted: " + e);
        }
    }
}

public class CountdownTickDemo {
    public static void main(String[] args) {
        CountdownThread countdown = new CountdownThread();
        TickThread tick = new TickThread();

        countdown.start();
        tick.start();
    }
}

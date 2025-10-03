class Chopstick { }

class Philosopher extends Thread {
    private final Chopstick left;
    private final Chopstick right;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted.");
        }
    }

    private void think() throws InterruptedException {
        System.out.println(getName() + " is thinking...");
        Thread.sleep(1000);
    }

    private void eat() throws InterruptedException {
        synchronized (left) {
            System.out.println(getName() + " picked up left chopstick.");
            Thread.sleep(100); // small delay to increase chance of deadlock

            synchronized (right) {
                System.out.println(getName() + " picked up right chopstick and is eating!");
                Thread.sleep(1000);
            }
        }
    }
}

public class DiningPhilosophersDeadlock {
    public static void main(String[] args) {
        Chopstick c1 = new Chopstick();
        Chopstick c2 = new Chopstick();

        // Philosopher-1 tries c1 -> c2
        Philosopher p1 = new Philosopher("Philosopher-1", c1, c2);

        // Philosopher-2 tries c2 -> c1 (reverse order)
        Philosopher p2 = new Philosopher("Philosopher-2", c2, c1);

        p1.start();
        p2.start();
    }
}

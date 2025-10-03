import java.util.concurrent.locks.ReentrantLock;

// Counter without lock (not thread-safe)
class CounterWithoutLock {
    private int count = 0;

    public void increment() {
        count++; // not thread-safe
    }

    public int getCount() {
        return count;
    }
}

// Counter with ReentrantLock (thread-safe)
class CounterWithLock {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();  // acquire lock
        try {
            count++;
        } finally {
            lock.unlock();  // always release lock
        }
    }

    public int getCount() {
        return count;
    }
}

// Worker thread that increments counter
class Worker extends Thread {
    private final int iterations;
    private final CounterWithoutLock counter1;
    private final CounterWithLock counter2;

    public Worker(CounterWithoutLock c1, CounterWithLock c2, int iterations) {
        this.counter1 = c1;
        this.counter2 = c2;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            counter1.increment();
            counter2.increment();
        }
    }
}

public class ReentrantLockDemo {
    public static void main(String[] args) {
        CounterWithoutLock counter1 = new CounterWithoutLock();
        CounterWithLock counter2 = new CounterWithLock();

        int iterations = 10000; // each thread increments this many times
        int numThreads = 5;

        Thread[] threads = new Thread[numThreads];

        // start threads
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Worker(counter1, counter2, iterations);
            threads[i].start();
        }

        // wait for all threads to finish
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // expected = numThreads * iterations
        int expected = numThreads * iterations;

        System.out.println("Expected count: " + expected);
        System.out.println("Without lock count: " + counter1.getCount());
        System.out.println("With ReentrantLock count: " + counter2.getCount());
    }
}

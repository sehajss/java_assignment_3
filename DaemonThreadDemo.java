class AutoSaveThread extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Auto-Save in progress...");
                Thread.sleep(3000); // 3 seconds delay
            }
        } catch (InterruptedException e) {
            System.out.println("Auto-Save thread interrupted: " + e);
        }
    }
}

public class DaemonThreadDemo {
    public static void main(String[] args) {
        // Create daemon thread
        AutoSaveThread autoSave = new AutoSaveThread();
        autoSave.setDaemon(true); // mark as daemon
        autoSave.start();

        // Main thread simulates file processing
        System.out.println("Main thread: File processing started...");
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Main thread: Processing chunk " + i);
                Thread.sleep(2000); // simulate work
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e);
        }

        System.out.println("Main thread: File processing completed.");
        // Once main thread ends, daemon thread also stops automatically
    }
}

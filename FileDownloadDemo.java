class DownloadTask extends Thread {
    private volatile boolean running = true; // stop flag

    @Override
    public void run() {
        int chunk = 1;
        while (running) {
            System.out.println("Downloading chunk " + chunk);
            chunk++;

            try {
                Thread.sleep(1000); // simulate time to download a chunk
            } catch (InterruptedException e) {
                System.out.println("Download thread interrupted: " + e);
            }
        }
        System.out.println("Download stopped gracefully.");
    }

    public void stopDownload() {
        running = false;
    }
}

public class FileDownloadDemo {
    public static void main(String[] args) {
        DownloadTask download = new DownloadTask();
        download.start();

        // Main thread simulates waiting for some time before stopping download
        try {
            Thread.sleep(5000); // let download run for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Requesting download to stop...");
        download.stopDownload();
    }
}

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriteByteStream {
    public static void main(String[] args) {
        String data = "Java I/O Streams Example";
        String fileName = "output.txt";

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            // Convert string to bytes and write
            fos.write(data.getBytes());
            System.out.println("Data written to " + fileName + " successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

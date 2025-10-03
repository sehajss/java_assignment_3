import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) {
        String fileName = "random_access.txt";

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            // Write initial data at the beginning
            raf.writeUTF("Hello World! This is RandomAccessFile example.");
            System.out.println("Initial data written.");

            // Move the file pointer to position 6 to overwrite part of the data
            raf.seek(6); // position starts from 0
            raf.writeUTF("JAVA"); // overwrite part of the file
            System.out.println("Data overwritten at position 6.");

            // Move file pointer back to beginning to read data
            raf.seek(0);
            System.out.println("Reading modified file content:");
            while (raf.getFilePointer() < raf.length()) {
                System.out.print(raf.readChar()); // reading character by character
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

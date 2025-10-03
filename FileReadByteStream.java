import java.io.FileInputStream;
import java.io.IOException;

public class FileReadByteStream {
    public static void main(String[] args) {
        String fileName = "example.txt"; // replace with your file path

        try (FileInputStream fis = new FileInputStream(fileName)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData); // convert byte to char
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

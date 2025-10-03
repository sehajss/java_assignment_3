import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyByteStream {
    public static void main(String[] args) {
        String sourceFile = "source.txt";  // source file path
        String destFile = "destination.txt";  // destination file path

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {

            byte[] buffer = new byte[1024]; // buffer to read/write
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead); // write bytes to destination
            }

            System.out.println("File copied successfully from " + sourceFile + " to " + destFile);

        } catch (IOException e) {
            System.out.println("Error during file copy: " + e.getMessage());
        }
    }
}

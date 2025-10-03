import java.io.FileReader;
import java.io.IOException;

public class FileReadCharacterStream {
    public static void main(String[] args) {
        String fileName = "example.txt"; // replace with your file path

        try (FileReader fr = new FileReader(fileName)) {
            int charData;
            while ((charData = fr.read()) != -1) {
                System.out.print((char) charData);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

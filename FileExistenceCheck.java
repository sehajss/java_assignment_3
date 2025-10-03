import java.io.File;
import java.io.IOException;

public class FileExistenceCheck {
    public static void main(String[] args) {
        String fileName = "example.txt"; // replace with your file path
        File file = new File(fileName);

        try {
            if (file.exists()) {
                System.out.println("File already exists: " + fileName);
            } else {
                if (file.createNewFile()) {
                    System.out.println("File created successfully: " + fileName);
                } else {
                    System.out.println("Failed to create the file: " + fileName);
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}

import java.io.File;

public class DeleteFileExample {
    public static void main(String[] args) {
        String fileName = "example.txt"; // replace with your file path
        File file = new File(fileName);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully: " + fileName);
            } else {
                System.out.println("Failed to delete the file: " + fileName);
            }
        } else {
            System.out.println("File does not exist: " + fileName);
        }
    }
}

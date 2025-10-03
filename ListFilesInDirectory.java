import java.io.File;
import java.util.Scanner;

public class ListFilesInDirectory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
        } else if (!directory.isDirectory()) {
            System.out.println("The path provided is not a directory.");
        } else {
            String[] files = directory.list();
            if (files != null && files.length > 0) {
                System.out.println("Files in directory '" + dirPath + "':");
                for (String fileName : files) {
                    System.out.println(fileName);
                }
            } else {
                System.out.println("Directory is empty.");
            }
        }

        scanner.close();
    }
}

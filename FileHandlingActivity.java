import java.io.*;

public class FileHandlingActivity {
    public static void main(String[] args) {
        // Your code here
        
        // a. Create main directory
        File dir = new File("JavaFileSystem");
        dir.mkdir();
        
        // b. Create three text files
        File notes = new File("JavaFileSystem/notes.txt");
        File data = new File("JavaFileSystem/data.txt");
        File log = new File("JavaFileSystem/log.txt");

        try {
            notes.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            data.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            log.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // c. Write messages to files
        
        // d. Read and display file contents
        
        // e. Create backup directory
        
        // f. Copy contents to backup file
        
        // g. List all files in both directories
    }
}
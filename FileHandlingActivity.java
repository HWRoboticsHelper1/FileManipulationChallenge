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
            e.getMessage();
        }
        
        // c. Write messages to files
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("JavaFileSystem/notes.txt"))) {
            bw.write("Don't forget to commit at each step!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("JavaFileSystem/data.txt"))) {
            bw.write("01100100 01100001 01110100 01100001");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("JavaFileSystem/log.txt"))) {
            bw.write("File made!\nFile edited!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        
        // d. Read and display file contents
        
        // e. Create backup directory
        
        // f. Copy contents to backup file
        
        // g. List all files in both directories
    }
}
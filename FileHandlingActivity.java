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
            System.out.println(e.getMessage());
        }

        // c. Write messages to files
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("JavaFileSystem/notes.txt"))) {
            bw.write("Don't forget to commit at each step!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("JavaFileSystem/data.txt"))) {
            bw.write("01100100 01100001 01110100 01100001");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("JavaFileSystem/log.txt"))) {
            bw.write("File made!\nFile edited!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // d. Read and display file contents
        try (BufferedReader br = new BufferedReader(new FileReader("JavaFileSystem/notes.txt"))) {
            System.out.println("notes.txt:");
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        try (BufferedReader br = new BufferedReader(new FileReader("JavaFileSystem/data.txt"))) {
            System.out.println("data.txt:");
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        try (BufferedReader br = new BufferedReader(new FileReader("JavaFileSystem/log.txt"))) {
            System.out.println("log.txt:");
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // e. Create backup directory
        File subDir = new File("JavaFileSystem/Backup");
        subDir.mkdir();

        // f. Copy contents to backup file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("JavaFileSystem/Backup/backup.txt"))) {
            for (String fileName : new String[] { "notes.txt", "data.txt", "log.txt" }) {
                try (BufferedReader br = new BufferedReader(new FileReader("JavaFileSystem/" + fileName))) {
                    bw.write(fileName + ":\n");
                    String line = br.readLine();
                    while (line != null) {
                        bw.write(line + "\n");
                        line = br.readLine();
                    }
                    bw.write("\n");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // g. List all files in both directories
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("In " + dir.getName() + ":");
            File[] files = dir.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }

        System.out.println();

        if (subDir.exists() && subDir.isDirectory()) {
            System.out.println("In JavaFileSystem/" + subDir.getName() + ":");
            File[] files = subDir.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }

        System.out.println();

        debugFileOperation();
    }

    public static void debugFileOperation() {
        try {
            // Creating a file with an invalid name (forward slash is invalid for file names on many OS)
            File file = new File("fileName.txt");
            
            // Attempting to write to the invalid file
            FileWriter writer = new FileWriter(file);
            writer.write("Will this fail?");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace(); 
        }
    }
}
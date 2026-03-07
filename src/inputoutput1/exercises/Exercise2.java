/**
 * 1. Use the File class to create a new file called "resources/students.txt".
 * 2. If the file already exists, print a message "File already exists."
 * 3. If it is newly created, print "File created successfully!"
 * 4. After creation, print the file’s absolute path.
 */

package inputoutput1.exercises;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise2
{
    public static void main(String[] args) {
        File file = new File(STR."\{Config.getIntroPath()}\{File.separator}students.txt");
        if (file.exists()) {
            System.out.println("File exists: " + file.getAbsolutePath());
        } else {
            System.out.println("File not found!");
            try(FileWriter writer = new FileWriter(file)) {
                writer.write("Hello World!");
                System.out.println("File created successfully!");

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}

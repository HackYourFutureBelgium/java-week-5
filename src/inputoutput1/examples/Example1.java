/**
 * 1. Create a File object pointing to a file called "notes.txt".
 * 2. Check if the file exists.
 * 3. If it doesn’t, print a message saying "File not found!".
 */

package inputoutput1.examples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Example1
{
    public static void main(String[] args) throws IOException {
        File file = new File("notes.txt");

        if (file.exists())
        {
            System.out.println("File exists: " + file.getAbsolutePath());
        }
        else
        {
            System.out.println("File not found!");
            try{
                FileWriter writer = new FileWriter(file);
                writer.write("Hello World!");

            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }

        }
    }
}
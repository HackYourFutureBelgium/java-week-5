/**
 * 1. Use FileInputStream and FileOutputStream to copy a file.
 * 2. Read from "source.txt" and write its content into "backup.txt".
 * 3. Use try-with-resources to automatically close both streams.
 * 4. After copying, print "File copied successfully!".
 * 5. Handle IOException properly.
 */

package inputoutput1.exercises;

import java.io.*;

public class Exercise5
{
    public static void main(String[] args)
    {
        String source_path = STR."\{Config.getIntroPath()}\{File.separator}smiling_pit.jpg" ;
        String copy_path = STR."\{Config.getIntroPath()}\{File.separator}smiling_pit_copy.jpg" ;
        try(
                FileInputStream in = new FileInputStream(source_path);
                FileOutputStream out = new FileOutputStream(copy_path)){
            int byteData;
            while((byteData = in.read()) != -1){
                out.write(byteData);
            }


            System.out.println("File copied successfully!");
        }
        catch (IOException e){
            System.out.println("Error " + e.getMessage());
        }

    }
}

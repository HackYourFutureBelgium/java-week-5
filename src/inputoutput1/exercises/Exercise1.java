/**
 * 1. Create a File object that points to "resources/info.txt".
 * 2. Check if the file exists.
 * 3. If it exists:
 *      - Print its absolute path.
 *      - Print its size in bytes.
 *      - Check if it’s readable and writable.
 * 4. If it doesn’t exist, print a message saying "File not found!".
 */

package inputoutput1.exercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Exercise1
{
    public static void main(String[] args)
    {
        String path = Config.getIntroPath() + File.separator + "info.txt";
        File file = new File(path);

        if(file.exists()){
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Size: " + file.length() + " bytes");
            System.out.println("Is readable: " +file.canRead());
            System.out.println("Is writable: " +file.canWrite());
        }

        else{
            System.out.println("File not found!");
        }

    }
}



/**
 * 1. Create a File object pointing to the ("resources") directory.
 * 2. List all files and folders in it.
 * 3. Print each item’s name:
 *      - Add "[DIR]" before folder names.
 *      - Add "[FILE]" before file names.
 * 4. Print the total number of files and directories found.
 */

package inputoutput1.exercises;

import java.io.File;

public class Exercise3
{

    public static void main(String[] args)
    {
        String path = Config.getResPath() + File.separator;
        File file = new File(path);
        if(file.exists()){
           for(File f:file.listFiles()){
               listFiles(f, 1);
           }
        }

    }
    protected static void listFiles(File file, int depth){
        if(file.isDirectory()){
            System.out.println("-".repeat(depth)+ "[DIR] " + file.getName());

            for(File j:file.listFiles()){
                listFiles(j, depth + 1);
            }
        }
        else {
            System.out.println("-".repeat(depth) + "[FILE] " + file.getName());
            // System.out.println("[PARENT] " + file.getParentFile());
        }

    }
}

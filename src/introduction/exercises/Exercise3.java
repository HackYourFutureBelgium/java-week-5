/**
 * 1. Create a File object pointing to the ("resources") directory.
 * 2. List all files and folders in it.
 * 3. Print each item’s name:
 *      - Add "[DIR]" before folder names.
 *      - Add "[FILE]" before file names.
 * 4. Print the total number of files and directories found.
 */

package introduction.exercises;

import java.io.File;

public class Exercise3
{
    public static void main(String[] args)
    {
        // 1. Create a File object pointing to the ("resources") directory.
        String path = Config.getResPath().toString();
        File dir = new File(path);
        if(dir.exists()){
           int[] result =  listFiles(dir, new int[]{0,0});
            System.out.println(result[0] + " Directories " + result[1] + " Files ");
            }
        else{
            System.out.println("File not found!");
        }

    }

    public static int[] listFiles(File dir, int[] count){
        if(dir.isDirectory()){
            System.out.println("[DIR] " + dir.getName());
           File[] files = dir.listFiles();
           if(files != null){
               for(File f:files){
                   if(f.isDirectory()){
                       count[0] +=1;
                       listFiles(f, count);
                   }
                   else{
                       System.out.println("[FILE] " + f.getParentFile().getName() + "." + f.getName());
                       count[1] +=1;
                   }
               }
           }

        }
        return count;
    }
}

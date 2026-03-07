/**
 * 1. Create a FileWriter to write into "resources/notes.txt".
 * 2. Write the following text lines into the file:
 *      - "Java I/O is powerful."
 *      - "Streams make reading and writing easier."
 * 3. Use try-with-resources for automatic stream closing.
 * 4. After writing, print "File written successfully!".
 */

package inputoutput1.exercises;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise4
{
	public static void main(String[] args)
	{
		String path = STR."\{Config.getIntroPath()}\{File.separator}notes.txt" ;
		File file = new File(path);
		try(FileWriter writer = new FileWriter(file, true)){
			writer.write("Java I/O is powerful.\n");
			writer.write("Streams make reading and writing easier.\n");
			System.out.println("File written successfully!");
		}
		catch (IOException e){
			System.out.println("Error " + e.getMessage());
		}

	}

}

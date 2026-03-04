/**
 *  1. Read input from System.in and store it in a String variable.
 *  2. Create a file whose name is the same as the user's input and write that input into the file.
 *  3. Use Scanner and FileWriter with try-with-resources.
 *  4. After writing, print "File written successfully!".
 *  5. Handle IOException properly.
 */

package introduction.exercises;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class Exercise6
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Path path = Config.getIntroPath();
        System.out.print("What is your name? ");
        String name = scanner.nextLine();
        String fileName = name.replaceAll("[\\s ,]", "_");
        System.out.println("filename " + fileName);

        System.out.print("Write a sentence");
        String str = scanner.nextLine();


    }
}

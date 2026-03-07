/**
 * 1. Create an interface named Printer with method: void print(String text).
 * 2. Inside main, create an anonymous class that implements Printer.
 * 3. Print the text: "Learning anonymous classes!".
 */

package modern.exercises;

public class Exercise3
{
    public static void main(String[] args)
    {
        // Instance of interface Printer.
        Printer printer = new Printer(){

            @Override
            public void print(String text) {
                System.out.println("Text: " + text);
            }
        };
        printer.print("Hello World!");

    }
}

interface Printer{
    void print(String text);
}

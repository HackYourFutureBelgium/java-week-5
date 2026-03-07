/**
 * 1. Create a method: public static String join(String... words)
 * 2. Join all words with a single space between them.
 * 3. Print the final sentence in main.
 */

package modern.exercises;

public class Exercise2
{
    public static void main(String[] args)
    {
        System.out.println("Join => " + join("Once", "upon","a","time"));

    }
    public static StringBuilder join(String... words){
        StringBuilder result = new StringBuilder();
        for(String str:words ){
            result.append(str + " ");
        }
        return result;
    }

}

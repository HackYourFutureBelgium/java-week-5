/**
 * 1. Create a String array with at least 4 names.
 * 2. Use an anonymous Comparator<String> to sort names by length.
 * 3. Print the sorted array.
 */

package modern.exercises;

public class Exercise4
{
    public static void main(String[] args)
    {
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        };
        int c =  comparator.compare("Roberta", "Mitchumette");
        System.out.println("Compare: " + c );


    }
}
interface Comparator<T>{
    public int compare(T a, T b);
}

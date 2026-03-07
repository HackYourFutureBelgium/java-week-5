/**
 * 1. Create a method: public static int sum(int... numbers)
 * 2. Return the total of all numbers.
 * 3. In main, call the method with 2, 3 and 5 arguments.
 */

package modern.exercises;

public class Exercise1
{
    public static void main(String[] args)
    {
        System.out.println("Sum => " + sum(10,30,5,4,1));
    }
    public static int sum(int... numbers){
        int result = 0;
        for(int nb:numbers ){
            result +=nb;
        }
        return result;
    }
}

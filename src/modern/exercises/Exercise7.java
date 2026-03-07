/**
 * 1. Create a record named Product with components: String name, double price.
 * 2. Create two Product objects in main.
 * 3. Print each product using accessor methods.
 * 4. Print the objects directly.
 * 5. Check if the two objects are equal.
 */

package modern.exercises;

public class Exercise7
{
    public static void main(String[] args)
    {
        Product2 chocoEggs = new Product2("Chocolate eggs", 34d);
        Product2 otherChocoEggs = new Product2("Chocolate eggs", 34d);
        Product2 orientalDelices = new Product2("Oriental delices", 12d);

        System.out.println(orientalDelices.name() + " " + orientalDelices.price());
        System.out.println(chocoEggs.name() + " " + chocoEggs.price());
        System.out.println(chocoEggs.toString());
        System.out.println(orientalDelices.toString());
        System.out.println(chocoEggs.equals(otherChocoEggs));
        System.out.println(chocoEggs.equals(orientalDelices));
    }
}

record Product2(String name, double price){};

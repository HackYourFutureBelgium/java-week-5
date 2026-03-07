package live_coding;
/*
Theory 2 -- final and Immutability
What does the keyword final mean for:

a variable?

a field?

a reference to an object?

Example:

final List<String> list = new ArrayList<>();
Why can we still add elements to the list?

Explain the difference between final reference and immutable object.


 */

import java.util.ArrayList;
import java.util.List;

public class Theory2 {
    static void main() {
        System.out.println("Theory 2 -- final and Immutability");
        // What does the keyword final mean for:
        //
        //a variable?

        // the value of a final variable could not be changed. It's imutable'.
        // Variable
        System.out.println("The assigned value of a final variable/field cannot be reassigned.");
        final String name = "Sophie";
        // name = "Babar"; // Generate an error => java: cannot assign a value to final variable name

        //a field?
      //  same for a field
        System.out.println("When a method is declared final, it means:");
        System.out.println("A subclass cannot override this method.");

        // a reference to an object?
        System.out.println("A final object reference cannot change but it could be modified.");
        final List<String> names = new ArrayList<>();
        names.add(name); // OK
        //names = new ArrayList<>(); //

        Dog zia = new Dog();
        System.out.println(zia.sound); // OK
       // System.out.println(zia.fur); // Raise an error => java: fur has private access in live_coding.Animal
        zia.setFur(true);
        System.out.println(zia.isFur());

    }
}

class Animal{
    protected String sound = "noise";
    private boolean fur = false;
    public void  setFur(boolean hasFur){
        this.fur = hasFur;
    }
    public boolean isFur(){
        return  this.fur;
    }
}

class Dog extends Animal{


}

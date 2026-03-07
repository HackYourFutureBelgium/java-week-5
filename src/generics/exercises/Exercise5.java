package generics.exercises;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise 4 (Comprehensive Practice)
 * 
 * Complete ALL the following tasks to practice everything you learned:
 * 
 * 1. Create a generic class Box<T> with:
 *    - Field: T value
 *    - Constructor that takes a value
 *    - Getter for value
 *    - toString() method
 * 
 * 2. Create Box<String> and Box<Integer> instances and print them
 * 
 * 3. Write a static method printAll(List<?> items) that prints each element
 * 
 * 4. Write a static method addDefaults(List<? super Integer> numbers)
 *    that adds integers 1, 2, 3 to the list
 * 
 * 5. Write a static method sumNumbers(List<? extends Number> numbers)
 *    that returns the sum as double
 * 
 * 6. Run all methods in main()
 */
public class Exercise5 {
    
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("Bernadette", "Scoubidou", "Dinausor"));
        List<Integer> ints = new ArrayList<>(Arrays.asList(518,-43,89,45));
        List<Double> dbs = new ArrayList<>(Arrays.asList(55d, -89.89, 54.87));
        List<LocalDateTime> ldt = new ArrayList<>(Arrays.asList(
                LocalDateTime.of(2024, 6, 5, 14, 30),
                LocalDateTime.now(),
                LocalDateTime.of(2027,1,1,1,1)
        ));
        System.out.println("=== Using Box Class ===\n");
        Box<Double> boxD = new Box<>(5843.879);
        Box<LocalDateTime> boxLdt = new Box<>(LocalDateTime.now());
        System.out.println(boxLdt.toString());
        System.out.println(boxD.toString());

        System.out.println("\n=== Using printAll ===\n");
        Box.printAll(words);
        Box.printAll(ints);
        Box.printAll(dbs);
        Box.printAll(ldt);

        System.out.println("\n=== Using addDefaults ===\n");
        System.out.println(Box.addDefaults(ints));
        List<Number> dbN = new ArrayList<>(Arrays.asList(55, -89.89, 54.87));
        System.out.println(Box.addDefaults(dbN));

        System.out.println("\n=== Using sumNumbers ===\n");
        System.out.printf("sumNumbers: %.2f %n" , Box.sumNumbers(dbN));

    }
}

// Task 1 - Create Box<T> class here
class Box<T>{
    private T value;
    public Box(T value){
        setValue(value);
    }
    // Task 3 - Implement printAll method
    public static void printAll(List<?> items) {

        // that prints each element
        int count = 0;
        for (Object item : items) {
            if (count < items.size() - 1) {
                System.out.print(item + ", ");
            }
            else {
                System.out.print(item + "\n");
            }
            count++;
        }
    }
    // Task 4 - Implement addDefaults method
    public static List<? super Integer> addDefaults(List<? super Integer> numbers) {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        return numbers;
    }
    // Task 5 - Implement sumNumbers method
    public static double  sumNumbers(List<? extends Number> numbers) {
        // that returns the sum as double
        double output = 0d;
        for (Number item:numbers) {
            output += item.doubleValue();
        }
        return output;
    }
    // GETTER & SETTER
    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    // toString
    @Override
    public String toString() {
        //return this.getValue().toString();
        // Better
        return String.valueOf(this.value);
    }
}


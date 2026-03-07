package generics.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise 2: Generic Methods and Bounded Types
 * 
 * Tasks:
 * 1. Write a generic method printArray(T[] array) that prints all elements
 *    - Try it with String[], Integer[], and Double[] arrays
 * 
 * 2. Write a generic method reverse(T[] array) that returns a new array
 *    with elements in reverse order
 *    - Try with different array types
 * 
 * 3. Write a method findMin(List<? extends Number> numbers) that returns
 *    the smallest number as a double
 *    - Try with List<Integer> and List<Double>
 * 
 * 4. Create a generic class Calculator<T extends Number>
 *    - Add add(), subtract(), multiply() methods that work with T
 *    - Return results as double
 *    - Try with Integer and Double
 * 
 * 5. Write a method countGreaterThan(T[] array, T element) that counts
 *    how many elements are greater than the given element
 *    - T must be Comparable
 *    - Try with different types
 */
public class Exercise2 {
    
    public static void main(String[] args) {
        String[] words = {"Hello", "World", "Java", "Zia petit toutou"};
        Integer[] numbers = {0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Double[] doubles = {133.99, 24.50, 33.99, 4d, 575.98};
        List<Integer> numbersList = new ArrayList<>(List.of(numbers));
        List<Double> doublesList = new ArrayList<>(List.of(doubles));

        System.out.println("=== Task 1: Print Array ===\n");
        printArray(words); printArray(numbers); printArray(doubles);

        System.out.println("\n=== Task 2: Reverse Array ===\n");
        Integer[] reverseNumbers = reverse(numbers);
        System.out.println(Arrays.toString(reverseNumbers));
        Double[] reverseDoubles = reverse(doubles);
        System.out.println(Arrays.toString(reverseDoubles));

        System.out.println("\n=== Task 3: Find Minimum ===\n");
        System.out.println("Min: " + findMin(numbersList));
        System.out.println("Min: " + findMin(doublesList));

        
        System.out.println("\n=== Task 4: Calculator ===\n");
        Calculator ci = new Calculator<>(numbers);
        System.out.println("[ADD] " +  ci.add());
        System.out.println("[SUBSTRACT] " +  ci.substract());
        System.out.println("[MULTIPLY] " +  ci.multiply());
        Calculator cd = new Calculator<>(doubles);
        System.out.println("[ADD] " +  cd.add());
        System.out.println("[SUBSTRACT] " +  cd.substract());
        System.out.printf("[MULTIPLY] %.2f %n",cd.multiply());


        
        System.out.println("\n=== Task 5: Count Greater Than ===\n");
        System.out.printf("Greater elements: %d%n", countGreaterThan(words, "Vernaculaire"));
        System.out.printf("Greater elements: %d%n", countGreaterThan(numbers, 5));
        System.out.printf("Greater elements: %d%n", countGreaterThan(doubles, 100d));

    }
    
    // Task 1 - Implement printArray method
    public static <T> void printArray(T[] array){
        if(array.length == 0){
            System.out.println("Empty array.");
            return;
        }
        for (T item:array){
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Task 2 - Implement reverse method
    public static <T> T[] reverse(T[] array){
       
        T [] reverse = array;
        int lg = reverse.length -1;
        for(int i = 0; i<= lg / 2; i++){
            T temp = reverse[i];
            reverse[i] = reverse[lg-i];
            reverse[lg-i] = temp;
        }
        return reverse;
    }
    
    
    // Task 3 - Implement findMin method
    public static double findMin(List<? extends Number> numbers){
        double min = numbers.get(0).doubleValue();
       for(Number item:numbers){
           double i = item.doubleValue();
           min = min < i ? min: i;
       }
        return min;
    }


    // Task 5 - Implement countGreaterThan method
   public static <T extends Comparable<T>> int countGreaterThan(T[] array, T element  ){
        int count = 0;
        for(T item:array){
            if( element.compareTo(item) < 0){
                System.out.println(item + " is greater than " + element);
                count++;
            }
        }
        return count;
    }
    
}

// Task 4 - Create Calculator<T extends Number> class here
class Calculator<T extends Number>{
    T[] array;
    public Calculator(T[] array){
        this.array = array;
    }
    protected double add(){
        double count = this.array[0].doubleValue();
        int lg = this.array.length;
        for (int i = 1; i < lg; i++) {
            count += this.array[i].doubleValue();
        }
       return count;
    }
    protected double substract(){
        double count = this.array[0].doubleValue();
        int lg = this.array.length;
        for (int i = 1; i < lg; i++) {
            count -= this.array[i].doubleValue();
        }
        return count;
    }
    protected double multiply(){
        double count = this.array[0].doubleValue();
        int lg = this.array.length ;
        for (int i = 1; i < lg; i++) {
            count *= this.array[i].doubleValue();
        }
        return count;
    }

}


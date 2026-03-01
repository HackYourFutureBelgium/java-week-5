package generics.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise 3: Wildcards and PECS
 * 
 * Tasks:
 * 1. Write a method printList(List<?> list) that prints any list
 *    - Test with different types of lists
 * 
 * 2. Write a method sumList(List<? extends Number> numbers) that calculates
 *    the sum of all numbers
 *    - Test with List<Integer>, List<Double>, and mixed List<Number>
 * 
 * 3. Write a method addThreeIntegers(List<? super Integer> list) that adds
 *    the numbers 10, 20, 30 to the list
 *    - Test with List<Integer>, List<Number>, and List<Object>
 * 
 * 4. Write a method copy(List<? extends T> source, List<? super T> dest)
 *    that copies all elements from source to destination
 *    - Demonstrate PECS principle
 *    - Test by copying List<Integer> to List<Number>
 *    - Test by copying List<Double> to List<Object>
 * 
 * 5. Write a method maxOfTwo(List<? extends Number> list1, 
 *                            List<? extends Number> list2)
 *    that returns the maximum element from both lists combined
 *    - Test with different number types
 * 
 * 6. BONUS: Create a method that demonstrates why you can't add to
 *    List<? extends Number> (producer)
 *    Write a comment explaining why
 */
public class Exercise3 {
    
    public static void main(String[] args) {
        System.out.println("=== Task 1: Print Any List ===\n");
        
        // TODO: Test printList with different types
        
        
        System.out.println("\n=== Task 2: Sum Numbers ===\n");
        
        // TODO: Test sumList
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);
        
        
        System.out.println("\n=== Task 3: Add Integers ===\n");
        
        // TODO: Test addThreeIntegers with different list types
        List<Integer> intList = new ArrayList<>();
        List<Number> numList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();
        
        
        System.out.println("\n=== Task 4: Copy Lists (PECS) ===\n");
        
        // TODO: Demonstrate PECS with copy method
        
        
        System.out.println("\n=== Task 5: Max of Two Lists ===\n");
        
        // TODO: Test maxOfTwo method
        
        
        System.out.println("\n=== Task 6: BONUS - Why Can't Add? ===\n");
        
        // TODO: Try to explain and demonstrate
        
    }
    
    // TODO: Task 1 - Implement printList
    
    
    // TODO: Task 2 - Implement sumList
    
    
    // TODO: Task 3 - Implement addThreeIntegers
    
    
    // TODO: Task 4 - Implement copy method
    
    
    // TODO: Task 5 - Implement maxOfTwo
    
    
    // TODO: Task 6 - BONUS
    
}

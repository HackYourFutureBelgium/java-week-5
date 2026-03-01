package generics.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example 3: Wildcards (?, ? extends, ? super)
 * 
 * This example demonstrates:
 * - Unbounded wildcards (?)
 * - Upper bounded wildcards (? extends)
 * - Lower bounded wildcards (? super)
 * - PECS principle: Producer Extends, Consumer Super
 */
public class Example3 {
    
    public static void main(String[] args) {
        System.out.println("=== Unbounded Wildcard (?) ===\n");
        
        // Can accept any type of list
        List<String> strings = Arrays.asList("Hello", "World");
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.5, 2.5);
        
        System.out.println("String list size: " + getSize(strings));
        System.out.println("Integer list size: " + getSize(integers));
        System.out.println("Double list size: " + getSize(doubles));
        
        System.out.println("\nPrinting all lists:");
        printList(strings);
        printList(integers);
        printList(doubles);
        
        System.out.println("\n=== Upper Bounded Wildcard (? extends) ===");
        System.out.println("Use when you want to READ from a structure\n");
        
        // Producer - we read from these lists
        List<Integer> intList = Arrays.asList(10, 20, 30);
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);
        List<Number> numList = Arrays.asList(100, 200.5, 300);
        
        // All work because Integer, Double extend Number
        System.out.println("Sum of integers: " + sumNumbers(intList));
        System.out.println("Sum of doubles: " + sumNumbers(doubleList));
        System.out.println("Sum of mixed numbers: " + sumNumbers(numList));
        
        System.out.println("\nMax values:");
        System.out.println("Max integer: " + findMax(intList));
        System.out.println("Max double: " + findMax(doubleList));
        
        System.out.println("\n=== Lower Bounded Wildcard (? super) ===");
        System.out.println("Use when you want to WRITE to a structure\n");
        
        // Consumer - we write to these lists
        List<Integer> integerList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();
        
        // All work because Integer, Number, Object can hold integers
        addIntegers(integerList);
        addIntegers(numberList);
        addIntegers(objectList);
        
        System.out.println("Integer list: " + integerList);
        System.out.println("Number list: " + numberList);
        System.out.println("Object list: " + objectList);
        
        System.out.println("\n=== PECS Principle Demo ===");
        System.out.println("Producer Extends, Consumer Super\n");
        
        // Source (producer) - we read from it
        List<Integer> source = Arrays.asList(100, 200, 300);
        
        // Destination (consumer) - we write to it
        List<Number> destination = new ArrayList<>();
        
        copyElements(source, destination);
        System.out.println("Copied elements: " + destination);
        
        System.out.println("\n=== Why PECS Matters ===\n");
        
        // Demonstrate flexibility
        List<Double> doubleSource = Arrays.asList(1.1, 2.2);
        List<Object> objectDest = new ArrayList<>();
        
        copyElements(doubleSource, objectDest);
        System.out.println("Copied doubles to Object list: " + objectDest);
    }
    
    // ========== UNBOUNDED WILDCARD (?) ==========
    
    /**
     * Accept any type of list, just need to know size
     */
    public static int getSize(List<?> list) {
        return list.size();
    }
    
    /**
     * Print any list - we don't care about the type
     */
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
    
    // ========== UPPER BOUNDED WILDCARD (? extends) ==========
    // Use when READING (Producer)
    
    /**
     * Sum any list of Numbers or subclasses
     * We can READ Number objects
     */
    public static double sumNumbers(List<? extends Number> numbers) {
        double sum = 0;
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        return sum;
    }
    
    /**
     * Find maximum in any Comparable list
     */
    public static <T extends Comparable<T>> T findMax(List<? extends T> list) {
        if (list.isEmpty()) {
            return null;
        }
        
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }
    
    // ========== LOWER BOUNDED WILDCARD (? super) ==========
    // Use when WRITING (Consumer)
    
    /**
     * Add integers to any list that can hold integers
     * We can WRITE Integer objects
     */
    public static void addIntegers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }
    
    /**
     * Add numbers to a list
     */
    public static void addNumbers(List<? super Number> list) {
        list.add(10);
        list.add(20.5);
        list.add(30L);
    }
    
    // ========== PECS PRINCIPLE ==========
    // Producer Extends, Consumer Super
    
    /**
     * Copy elements from source (producer) to destination (consumer)
     * 
     * source: ? extends T - we READ from it (producer)
     * destination: ? super T - we WRITE to it (consumer)
     */
    public static <T> void copyElements(List<? extends T> source, 
                                        List<? super T> destination) {
        for (T element : source) {
            destination.add(element);
        }
    }
    
    /**
     * Another PECS example: process and collect results
     */
    public static void processNumbers(List<? extends Number> input,
                                     List<? super Double> output) {
        for (Number num : input) {
            // Read from input, process, write to output
            double squared = Math.pow(num.doubleValue(), 2);
            output.add(squared);
        }
    }
}

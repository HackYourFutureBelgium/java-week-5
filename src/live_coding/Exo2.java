package live_coding;

/*
Create a utility class:
Statistics
Add a static method:
public static double average(int... numbers)
Requirements:
If no numbers are provided, return 0.
Calculate the average value.
Print the maximum number.
Example usage:
double avg = Statistics.average(5, 8, 12, 3);
Example output:
Average: 7.0 Max: 12
Bonus:
Convert the numbers varargs into a List and compute the maximum using Collections.max().

 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Exo2 {
    static void main(String[] args) {
        double avg = Statistics.average(5, 8, 12, 3, 334);

    }
}
class Statistics{
    public static double average(int... numbers){
        int lg = numbers.length;
        if(lg == 0){
            return 0d;
        }
        System.out.println();
        // Cast numbers
       List<Integer> integers = new ArrayList<>();
        //int max = Collections.max(numbers);
        int count = 0;
        for(int nb:numbers){
          //  max =  max < nb ? max:nb;
            integers.add(nb);
            count += nb;
        }
        int max = Collections.max(integers);
        double avr = ((double) count / lg);
        System.out.printf("Max: %d Average: %.2f %n", max, avr);

        return avr;
        }


}

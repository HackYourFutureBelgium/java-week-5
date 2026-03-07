package live_coding;

public class Coding2 {
    static void main() {
        int[][] temps = {
                {3, 5, 2, 4},   // Week 1
                {6, 1, 0, 2},   // Week 2
                {4, 4, 3, -5}    // Week 3
        };
        // 1.Return the average temperature of a single week.
        int count = 1;
        for (int[] week:temps){
            System.out.println("Week " + count + " average temperature: " + weekAverage(week) + "°C");
            count++;
        }
        // 2.Return the lowest temperature in the entire 2D array.
        System.out.println("Coldest temp: " + coldestTemperature(temps));

    }
    // Return the average temperature of a single week.
    public static int weekAverage(int[] week){
        int count = 0;
        int lg = week.length;
        if(lg == 0){
            return count;
        }

        for(int temp:week){
            count += temp;
        }
        return count / lg;
    }
    // Return the lowest temperature in the entire 2D array.
    public static int coldestTemperature(int[][] temps){
       int coldest = min(temps[0]);
        for(int i=1; i<temps.length; i++){
           coldest = Math.min(coldest, min(temps[i]));
        }
        return coldest;
    }
    public static int min(int[] week){
        int min = week[0];
        for(int i=1; i<week.length; i++){
            min = Math.min(min, week[i]);
        }
        return min;
    }
}



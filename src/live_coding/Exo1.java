package live_coding;
/*
/*
Write a method:
public static int readPositiveInt(Scanner scanner)
Requirements:
Ask the user:
Enter a positive integer:
The program must:
Reject inputs that are not integers
Reject integers less than or equal to 0
If the input is invalid, ask again.
The method should return the valid positive integer.
Example interaction:
Enter a positive integer: -3 Must be greater than 0
Enter a positive integer: hello Invalid input
Enter a positive integer: 7 You entered: 7

In main():
Create a Scanner
Call readPositiveInt(scanner)
Print the returned value
 */


import java.util.Scanner;

public class Exo1 {

    public  static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int play = -1;
        while(play < 0){
            System.out.print("Enter a positive integer: ");

          play = readPositiveInt(scanner);
          if(play != -1){
              System.out.println("You entered " + play);
          }
        }
        scanner.close();

    }
    public static int readPositiveInt(Scanner scanner){
        if(!scanner.hasNextInt()){
            System.out.println("Input not valid : Please enter an integer.");
            scanner.next();
            return -1 ;
        }
        int nb = scanner.nextInt();
        if(nb <= 0 ){
            System.out.println("Input not valid : must be greater than 0.");
            return -1;
        }
        return nb;
    }
}

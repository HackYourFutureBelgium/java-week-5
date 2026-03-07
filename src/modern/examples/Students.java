package modern.examples;

/*
OOP Design Challenge — Student Ranking System
You are building a small student ranking system for a school.
The school wants to display students sorted by their grades, from highest to lowest.
Your task is to design a system that makes this possible.

Step 1 — Create the Student class
Create a class called Student.
Each student has:
name
gradeRequirements:
fields must be private
provide a constructor
provide getters

override toString() so students can be printed nicely
Example:
Alice (90)
Bob (75)
Charlie (82)

Step 2 — Create some students
In main():
create a List<Student>

add at least 5 students
Example:

List<Student> students = new ArrayList<>();

students.add(new Student("Alice", 90));
students.add(new Student("Bob", 75));
students.add(new Student("Charlie", 82));
students.add(new Student("Emma", 65));
students.add(new Student("David", 80));

Step 3 — Sort the students
The school wants to print students from highest grade to lowest grade.
Your task:
Sort the students by gradeThink about the following questions:
How can Java know which student is greater or smaller?

How can two Student objects be compared?
Where should that comparison logic live?
After sorting, print the list.
Expected output:
Students ranked by grade:

Alice (90)
Charlie (82)
David (80)
Bob (75)
Emma (65)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Students {
    static void main() {
        String[] names = new String[]{"Bob", "Andrei", "Capucine", "Gomathi", "Emma", "Preeti", "Alison", "john"," ", "basel", "Kien"};
        Random rd = new Random();
        List<Student> students = new ArrayList<>();
        for(String name:names){
            try{
                students.add(new Student(name, rd.nextInt(101)));
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

}


// 1.Class student
record Student(String name, int grade){
    public Student {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank, please fix!");
        }
        if (grade <= 0) {
            throw new IllegalArgumentException("Grade cannot be negative or null, please fix!");
        }
    }
    // Override toString() so students can be printed nicely E.g. Bob (75).
    public String toString(){
        return STR."\{this.name()} (\{this.grade()})";
    }

}
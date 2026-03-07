/**
 * 1. Create a sealed interface Shape that permits Circle and Rectangle.
 * 2. Create classes/records for Circle and Rectangle.
 * 3. Write a method area(Shape shape) using pattern matching for instanceof.
 * 4. In main, create one Circle and one Rectangle and print their areas.
 */

package modern.exercises;

public class Exercise6
{
    public static void main(String[] args)
    {
        Shape rec = new Rectangle(10d,3d);
        Shape circle = new Circle(32d);
        printArea(rec);
        printArea(circle);
    }

    public static void printArea(Shape shape){
        if(shape instanceof Rectangle rec){
            System.out.println("Rectangle aera = " + rec.getWidth() + " * " + rec.getHeight() + " = " + rec.aera());
        }
        if(shape instanceof Circle cir){
            System.out.println("Circle aera = " + Math.PI + " * " +  cir.getRadius() + " * " + cir.getRadius() + " = " + cir.aera());
        }
    }

}
sealed interface Shape permits Circle, Rectangle {
   Double aera();
}

final class Circle implements Shape {
Double radius;
public Circle(Double radius){
    this.radius = radius;
}
    @Override
    public Double aera() {
        return Math.PI * radius * radius;
    }

    public Double getRadius() {
        return radius;
    }
}
final class Rectangle implements Shape{
Double width;
Double height;
    public Rectangle(Double w, Double h){
        this.width = w;
        this.height= h;
    }
    @Override
    public Double aera() {
        return width * height;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }
}

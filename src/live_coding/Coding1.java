package live_coding;
/*
## Coding Question 1 -- Composition (Car and Engine)

Create two classes:

Engine, Car

## Engine

Fields:
```java
horsePower
```
Method:

start()

When start() is called, print:

Engine started

## Car

Fields:
```java
brand
```
Engine engine

Method:

drive()

## Requirements:

A Car has an Engine (composition).

When drive() is called:

The engine should start

Then print:
```java
Car is driving
```
In main()

Create an Engine

Pass the engine to a Car

Call drive()

Example output:
```java
Engine started
Car is driving
```
Discussion point:

Why is this example composition instead of inheritance?
 */

public class Coding1 {
    static void main() {

Car mercedes = new Car("Mercedes");
mercedes.drive();
    }
}
class Engine{
    private int horsePower;
    public Engine(int horsePower){
        setHorsePower(horsePower);
    }
    // START METHOD
    public void start(){
        System.out.println("Engine started.");
    }
    // SETTER
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    //GETTER
    public int getHorsePower() {
        return horsePower;
    }
}
class Car{
    private Engine engine = new Engine(15);
    private String brand;
    public Car(String brand){
        setBrand(brand);
    }
    public void drive(){
        engine.start();
        System.out.println("Car is driving");
    }
    // SETTER.
    public void setBrand(String brand) {
        this.brand = brand;
    }
}

Varargs • Anonymous Classes • Builder Pattern

This module covers three powerful Java features that improve flexibility, readability, and API design.

They may look unrelated, but they all help you write:

Cleaner method calls

More flexible behavior

More readable object creation

1️⃣ Varargs — Flexible Method Parameters
What Problem Does It Solve?

Sometimes we don’t know how many arguments a method will receive.

Instead of writing:

```java
sum(1, 2);
sum(1, 2, 3);
sum(1, 2, 3, 4);

```

We use varargs.


```java
public static int sum(int... numbers) {
int total = 0;
for (int n : numbers) {
    total += n;
}
return total;
}
//Usage
sum(1, 2);
sum(1, 2, 3, 4, 5);
```
Internally, numbers is treated as an array.

Rules

Only one varargs parameter per method

It must be the last parameter

It behaves like an array

```java
public void example(String name, int... scores) // ✅ correct
```
Mini Exercise

Create a method:

public static String join(String... words)

It should return all words combined into one sentence.

2️⃣ Anonymous Classes — One-Time Behavior
What Problem Does It Solve?

Sometimes we need a class only once.

Instead of creating a full class file, we can create it inline.

Example

```java
interface Printer {
    void print();
}

```

```java
//We want to create a printer
Printer p = new Printer() {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
};
p.print("Hello");

```

It is also possible with generics too

```java
Comparator<String> comparator = new Comparator<>() {
    @Override
    public int compare(String a, String b) {
        return a.length() - b.length();
    }
};
```
This creates an anonymous class implementing Comparator.

When Do We Use It?

Comparator

Runnable

Event listeners

Strategy pattern

Anonymous Class vs Lambda

If the interface has one abstract method, we can use lambda:

```java
Comparator<String> comparator =
(a, b) -> a.length() - b.length();
```
✔ Lambda works only for functional interfaces
❌ Anonymous classes work for abstract classes too

Mini Exercise

Sort a list of integers in reverse order using:

Anonymous class

Then using lambda

3️⃣ Builder Pattern — Clean Object Creation
What Problem Does It Solve?

When constructors have too many parameters:

User user = new User("Bora", 35, true, "Belgium", "Developer");

Hard to read. Easy to mix parameters.

```java
Builder Solution
public class User {
    private String name;
    private int age;
    private boolean active;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.active = builder.active;
    }

    public static class Builder {
        private String name;
        private int age;
        private boolean active;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder active(boolean active) {
            this.active = active;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

```
Usage

```java
User user = new User.Builder()
.name("Bora")
.age(35)
.active(true)
.build();

```
Much more readable ✅

When Should You Use Builder?

Many optional parameters

Immutable objects

Clean API design

🔥 Mini Integration Example

Example of all three concepts:

```java
public static void sendMessage(String message, String... recipients) {
    for (String r : recipients) {
        System.out.println("Sending to " + r);
    }
}
Runnable onComplete = new Runnable() {
    @Override
    public void run() {
        System.out.println("Done!");
    }
};
Notification notification = new Notification.Builder()
.message("Hello")
.priority(1)
.build();

```
Now we have:

Flexible input → varargs

Custom behavior → anonymous class

Clean object creation → builder

🧠 Learning Outcomes

After this module, you should be able to:

✅ Use varargs correctly
✅ Understand when to use anonymous classes
✅ Replace anonymous classes with lambdas when possible
✅ Implement the Builder pattern
✅ Understand how these tools improve API design

🎯 Why These Topics Matter

These concepts appear frequently in:

Java libraries

Frameworks like Spring

Professional backend code

Clean architecture patterns
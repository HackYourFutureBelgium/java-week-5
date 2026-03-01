# Generics in Java

Generics allow you to write flexible, reusable code that works with different types while maintaining **type safety**. They help prevent runtime errors by catching type mismatches at compile time.

---

## Why Use Generics?

**Without Generics:**
```java
List list = new ArrayList();
list.add("Hello");
list.add(123);
String s = (String) list.get(1); // Runtime error: ClassCastException!
```

**With Generics:**
```java
List<String> list = new ArrayList<>();
list.add("Hello");
// list.add(123); // Compile-time error - won't even compile!
String s = list.get(0); // No casting needed
```

---

## 1. Generic Classes

A generic class is defined with a type parameter in angle brackets `<T>`.

```java
public class Box<T>
{
    private T value;

    public Box(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return value;
    }
    
    public void setValue(T value)
    {
        this.value = value;
    }
}
```

**Usage:**
```java
Box<String> stringBox = new Box<>("Hello");
Box<Integer> intBox = new Box<>(42);

String str = stringBox.getValue(); // No casting needed
Integer num = intBox.getValue();
```

**Common Type Parameter Names:**
- `T` - Type
- `E` - Element (used in collections)
- `K` - Key
- `V` - Value
- `N` - Number

---

## 2. Generic Methods

You can create methods that work with any type, independent of the class.

```java
public class Utils
{
    // Generic method - notice <T> before return type
    public static <T> void printArray(T[] array)
    {
        for (T element : array)
        {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    public static <T> T getFirst(List<T> items)
    {
        if (!items.isEmpty())
        {
            return items.get(0);
        }
        return null;
    }
}
```

**Usage:**
```java
Integer[] numbers = {1, 2, 3, 4, 5};
String[] words = {"Hello", "World"};

Utils.printArray(numbers); // 1 2 3 4 5
Utils.printArray(words);   // Hello World
```

---

## 3. Bounded Type Parameters

Sometimes you want to restrict which types can be used with generics.

### Upper Bound (`extends`)

```java
// T must be Number or a subclass of Number
public class NumberBox<T extends Number>
{
    private T number;

    public NumberBox(T number)
    {
        this.number = number;
    }

    public double toDouble()
    {
        return number.doubleValue(); // We can call Number methods!
    }
}
```

**Usage:**
```java
NumberBox<Integer> intBox = new NumberBox<>(42);
NumberBox<Double> doubleBox = new NumberBox<>(3.14);
// NumberBox<String> strBox = new NumberBox<>("Hi"); // Error: String is not a Number
```

### Multiple Bounds

```java
public class Processor<T extends Comparable<T> & Serializable>
{
    // T must implement both Comparable AND Serializable
}
```

---

## 4. Wildcards

Wildcards (`?`) are used when you don't care about the exact type.

### Unbounded Wildcard (`?`)

```java
// Accept any type of list
public static void printList(List<?> list)
{
    for (Object obj : list)
    {
        System.out.println(obj);
    }
}
```

### Upper Bounded Wildcard (`? extends Type`)

Use when you want to **read** from a structure.

```java
// Accept List of Number or any subclass (Integer, Double, etc.)
public static double sumNumbers(List<? extends Number> numbers)
{
    double sum = 0;
    for (Number n : numbers)
    {
        sum += n.doubleValue();
    }
    return sum;
}
```

**Usage:**
```java
List<Integer> ints = Arrays.asList(1, 2, 3);
List<Double> doubles = Arrays.asList(1.5, 2.5);

sumNumbers(ints);    // Works!
sumNumbers(doubles); // Works!
```

### Lower Bounded Wildcard (`? super Type`)

Use when you want to **write** to a structure.

```java
// Accept List of Integer or any superclass (Number, Object)
public static void addIntegers(List<? super Integer> numbers)
{
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
}
```

**Usage:**
```java
List<Integer> ints = new ArrayList<>();
List<Number> nums = new ArrayList<>();
List<Object> objs = new ArrayList<>();

addIntegers(ints);  // Works!
addIntegers(nums);  // Works!
addIntegers(objs);  // Works!
```

---

## 5. PECS Principle

**Producer Extends, Consumer Super**

- Use `<? extends T>` when you **get** values (producer)
- Use `<? super T>` when you **put** values (consumer)

```java
// Producer - reading from source
public static void copy(List<? extends Number> source, 
                       List<? super Number> destination)
{
    for (Number num : source)
    {
        destination.add(num);
    }
}
```

---

## 6. Type Erasure

Java generics use **type erasure** - generic type information is removed at runtime.

```java
List<String> strings = new ArrayList<>();
List<Integer> ints = new ArrayList<>();

// At runtime, both are just List (raw type)
System.out.println(strings.getClass() == ints.getClass()); // true
```

**Implications:**
- Cannot create arrays of generic types: `new T[10]` ❌
- Cannot use primitives with generics: `List<int>` ❌ (use `List<Integer>` ✅)
- Cannot instantiate type parameters: `new T()` ❌

---

## 7. Tips

### ❌ Avoid Raw Types

```java
List list = new ArrayList(); // Raw type - no type safety!
list.add("Hello");
list.add(123);
String s = (String) list.get(1); // Runtime error!
```

### ✅ Use Generic Types

```java
List<String> list = new ArrayList<>(); // Type safe!
```

### ❌ Cannot Use Primitives

```java
List<int> numbers = new ArrayList<>(); // Error!
```

### ✅ Use Wrapper Classes

```java
List<Integer> numbers = new ArrayList<>(); // Correct!
```

**Start simple** - Begin with basic generic classes before wildcards

**Practice PECS** - "Producer Extends, Consumer Super" is key!

---

## ❓ Common Questions

**Q: When do I use `<T>` vs `<?>`?**  
A: Use `<T>` when you need to refer to the type. Use `<?>` when you don't care about the type.

**Q: Extends or Super?**  
A: Use `extends` when reading (producer), `super` when writing (consumer). Remember PECS!

**Q: Why can't I create `new T[]`?**  
A: Type erasure! Generic type info is removed at runtime. Create `Object[]` instead.

**Q: Can I use primitives like `List<int>`?**  
A: No! Use wrapper classes: `List<Integer>`, `List<Double>`, etc.

---

## Learning Outcomes

After studying generics, you should be able to:

✅ Understand why generics improve type safety  
✅ Create and use generic classes  
✅ Write generic methods  
✅ Use bounded type parameters (`extends`)  
✅ Work with wildcards (`?`, `? extends`, `? super`)  
✅ Apply the PECS principle  
✅ Understand type erasure limitations  

---

## Next Steps

Practice with:
1. Creating your own generic classes
2. Writing generic utility methods
3. Working with bounded types and wildcards
4. Understanding when to use `extends` vs `super`

# 🧩 Introduction to Java I/O (Input/Output)

Java provides a rich set of **I/O (Input/Output)** classes to read and write data — whether it’s from files, keyboard input, or network connections.

Understanding how data flows in and out of a program is essential for building real-world backend systems that store, log, or process information.

---

## 📘 What is I/O?

**Input** → Data that comes **into** a program (e.g., reading from a file).
**Output** → Data that goes **out** of a program (e.g., writing to a file or console).

Every I/O operation involves a **stream** — a continuous flow of data between the program and a source/destination.

---

## 🔄 I/O Streams in Java

A **stream** is a sequence of data.
Java provides two main categories of streams:

| Type                  | Description                                     | Common Classes                                                                     |
|-----------------------|-------------------------------------------------|------------------------------------------------------------------------------------|
| **Byte Streams**      | Used for binary data (e.g., images, audio, PDF) | `InputStream`, `OutputStream`, `FileInputStream`, `FileOutputStream`               |
| **Character Streams** | Used for text data (characters, strings)        | `Reader`, `Writer`, `FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter` |

---

## 🧠 Byte Streams vs Character Streams

| Feature      | Byte Streams                             | Character Streams                    |
|--------------|------------------------------------------|--------------------------------------|
| Data type    | Reads/writes **bytes (8-bit)**           | Reads/writes **characters (16-bit)** |
| Suitable for | Binary data (images, audio, video, etc.) | Text data (UTF-8, ASCII, etc.)       |
| Base classes | `InputStream`, `OutputStream`            | `Reader`, `Writer`                   |
| Example      | `FileInputStream`, `FileOutputStream`    | `FileReader`, `FileWriter`           |

---

## 🗂️ Working with the `File` Class

The `java.io.File` class is used to represent **file and directory paths** in the file system.
It helps check whether a file exists, its size, permissions, and more.

### Common Methods:

| Method              | Description                        |
|---------------------|------------------------------------|
| `exists()`          | Checks if file/directory exists    |
| `isFile()`          | Returns `true` if it’s a file      |
| `isDirectory()`     | Returns `true` if it’s a directory |
| `length()`          | Returns file size in bytes         |
| `getAbsolutePath()` | Returns full path                  |
| `createNewFile()`   | Creates a new empty file           |
| `delete()`          | Deletes the file                   |

---

## ⚙️ Closing Resources Properly

When working with files, you must **close** streams after use to free up system resources.
Forgetting to close them can cause **memory leaks** or **locked files**.

### - Recommended Practice: Try-With-Resources

Introduced in Java 7, `try-with-resources` automatically closes the stream after the block finishes — even if an exception occurs.

```java
public class Main
{
    public static void main(String[] args) 
    {
        try (FileReader reader = new FileReader("data.txt"))
        {
            // read file
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
```

No need for `finally { reader.close(); }` — Java does it for you!

---

## 🧩 Summary

- Java I/O uses **streams** to read and write data
- **Byte Streams** for binary data, **Character Streams** for text
- The **File class** helps check and manipulate files
- Always **close streams** or use **try-with-resources**

---

## 🧠 Learning Outcomes

By completing this section, students will:

- Understand how **Java I/O Streams** work
- Know when to use **Byte** vs **Character Streams**
- Use the **File class** to check and manipulate files
- Apply **try-with-resources** for safer I/O operations
- Read, write, and copy files in Java

---


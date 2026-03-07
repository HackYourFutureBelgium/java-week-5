# ✍️ Writing Files in Java

Writing data to files is an essential part of many Java applications -- from saving logs and reports to exporting results.
Java provides several convenient classes for writing **text data**, ensuring efficient and safe file operations.

---

## 🔑 Key Concepts

### **1. FileWriter**

* Used for writing **characters** to text files.
* Creates a new file if it doesn’t exist.
* Overwrites the file by default (unless append mode is enabled).
* Slower for large files because it doesn’t use buffering internally.

📘 **Example:**

```java
FileWriter writer = new FileWriter("data.txt");
writer.write("Hello, Java!");
writer.close();
```

---

### **2. BufferedWriter**

* Wraps around `FileWriter` for faster, buffered writing.
* Reduces I/O calls by writing larger chunks of data at once.
* Provides a convenient `newLine()` method for line breaks.

📘 **Example:**

```java
BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
writer.write("This is line 1");
writer.newLine();
writer.write("This is line 2");
writer.close();
```

---

### **3. Appending to a File**

By default, writing replaces the file’s content.
To **append** new data instead, pass `true` as the second argument:

```java
new FileWriter("log.txt", true);
```

This is useful for logging or adding new entries without losing old data.

---

### **4. Flushing and Closing Streams**

* **`flush()`** → forces any buffered data to be written to the file.
* **`close()`** → closes the stream and releases system resources.
* **Always close or use try-with-resources** to ensure your data isn’t lost.

---

### **5. Try-With-Resources for Safety**

Try-with-resources automatically closes streams, even if an exception occurs:

```java
try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) 
{
    writer.write("Data safely written!");
}
```

---

## 🧠 Summary

- Use `FileWriter` for simple text writing
- Use `BufferedWriter` for performance and convenience
- Use `FileWriter("file.txt", true)` to append
- Always close or use try-with-resources
- Use `flush()` to ensure data is written before closing

---

## 🧩 Learning Outcomes

By completing this section, students will:

- Write text data using **FileWriter** and **BufferedWriter**
- Append to files without overwriting existing data
- Manage file output efficiently with **flush()** and **close()**
- Safely handle exceptions using **try-with-resources**
- Understand how to generate and save structured output

---

package live_coding;
/*
/*
Interfaces + Polymorphism + Collections + (optional) sealed
Design a tiny logging system.
Create an interface:
interface Logger {
    void log(String message);
}
Implement two loggers:
ConsoleLogger → prints: "[CONSOLE] " + message
FileLogger → writes logs into a file named app.log (append mode)
Create a class App with a field:
private final List<Logger> loggers;
Constructor receives the list (constructor injection).
Method:
public void run()
Inside run():
Log "App started"
Log "Doing work..."
Log "App finished"
In main():
Create both loggers
Put them into a list
Create App and call run()
Why it's final boss:
Design
Discuss Interface and DIP
Bonus:
Make Logger a sealed interface permitting only those two implementations.
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exo3 {
    static void main() {
        String p = "./HYFBE-java-week-5/resources";
        ConsoleLogger cl = new ConsoleLogger();
        FileLogger fl = new FileLogger(p);
       /* String mess = "Hello world!";
        cl.log(mess);
        fl.log(mess);*/

        App app = new App(cl,fl);
        app.run();

    }

}
class App{
    private final List<Logger> loggers = new ArrayList<>();
    public App(Logger... logger){
        for(Logger l:logger){
            this.loggers.add(l);
        }
    }
    public void run(){
        System.out.println();
        for(Logger l:loggers){
            l.log("App have started \n");
            l.log("App doing work...\n");
            l.log("App finished.");
        }

    }

}
interface Logger {
    void log(String message);
}
class ConsoleLogger implements Logger{
    @Override
    public void log(String message) {
        System.out.println("[CONSOLE] " + message);
    }
}
class FileLogger implements Logger{
    private File file;
    private String path;

    public FileLogger(String path){
        this.path = path + File.separator +  "app.log";
        this.file = new File(path);
    }
    @Override
    public void log(String message) {
        try (FileWriter writer = new FileWriter(path, true))
        {
            writer.write(message);
            System.out.println("Data successfully written to file.");
        }
        catch (IOException e)
        {
            System.out.println("Error writing to file: " + e.getMessage());
        }


    }
}


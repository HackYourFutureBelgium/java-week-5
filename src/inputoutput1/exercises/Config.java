package inputoutput1.exercises;


import java.nio.file.Path;

public class Config {

    public static Path getResPath(){
        return Path.of(".",
                "HYFBE-java-week-5",
                "resources");
    }
    public static Path getIntroPath(){
        return Path.of(".",
                "HYFBE-java-week-5",
                "resources",
                "introduction");
    }
}

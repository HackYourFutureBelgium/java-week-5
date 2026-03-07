package live_coding;

import java.util.ArrayList;
import java.util.List;

public class Coding3 {
    static void main() {
        List<NotificationService> services = new ArrayList<>();
        services.add(new Email());
        services.add(new SMS());
        for(NotificationService ns:services){
            notifyAllUsers(ns,"This is a beautiful day!");
        }


    }
    public static void notifyAllUsers(NotificationService ns, String message){
        if(ns instanceof SMS){
            System.out.println("New SMS: " + message);
        }
       else if(ns instanceof Email){
            System.out.println("New Email: " + message);
        }
        if(ns instanceof SMS){
            System.out.println(message);
        }

    }
}

abstract class NotificationService{

}

class SMS extends NotificationService{

}
class Email extends NotificationService{}
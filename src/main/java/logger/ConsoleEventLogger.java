package logger;

import Event.Event;

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event msg){
        System.out.println(msg);
    }
}

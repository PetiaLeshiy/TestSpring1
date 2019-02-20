package logger;

import Event.Event;

import java.util.ArrayList;
import java.util.List;

public class CombinedEventLogger implements EventLogger{

List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
    this.loggers = loggers;
    }

    @Override
    public void logEvent(Event msg) {
    for (EventLogger logger : loggers) {
        logger.logEvent(msg);
    }
    }
}

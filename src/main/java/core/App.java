package core;

import Event.Event;
import Event.EventType;
import beans.Client;
import logger.ConsoleEventLogger;
import logger.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    public App() {


    }

    public void logEvent(EventType type, Event event, String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        EventLogger logger = loggers.get(type);
        if (logger == null) {
        logger = defaultLogger;
        }
         logger.logEvent(event);

       logger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app =(App) ctx.getBean("app");
        Event event = (Event) ctx.getBean("event");
        app.logEvent(EventType.ERROR, event,"Some event for user 1");
        event = (Event) ctx.getBean("event");
        app.logEvent(EventType.INFO, event, "Some event for user 2");
        event = (Event) ctx.getBean("event");
        app.logEvent(null, event, "Some event for user 3");



        ctx.close();
        //core.App app = new core.App();
//        app.client = new beans.Client("1", "John Smith");
//        app.eventLogger = new logger.ConsoleEventLogger();
//        app.logEvent("Some event for user 1");
    }
}

package logger;

import Event.Event;

import java.util.LinkedList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger{
    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
        cache = new LinkedList<>();
    }

    private int cacheSize;
    private List<Event> cache;

    @Override
    public void logEvent(Event msg) {
        cache.add(msg);

        if (cache.size() == cacheSize) {
            writeEventFromCache();
        cache.clear();
            System.out.println(cache.size());
        }
        super.logEvent(msg);
    }

    private void writeEventFromCache() {
    for (Event event :cache) {
        super.logEvent(event);
    }
    }

    private void destroy(){

        if (cache.size() != 0)
            for (Event event : cache){
            super.logEvent(event);}
    }
}

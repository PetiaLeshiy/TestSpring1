package Event;

import java.text.DateFormat;
import java.util.Date;

public class Event {
    private int id = (int) (Math.random()*1000);

    private String msg;

    private Date date;
    private DateFormat df;
    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date ) +
                '}';
    }
}

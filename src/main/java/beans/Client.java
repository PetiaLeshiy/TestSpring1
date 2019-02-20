package beans;

public class Client {
    private String id;
    private String fullName;

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String greeting;

    public Client() {

    }

    public String getFullName() {
        return fullName;
    }

    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

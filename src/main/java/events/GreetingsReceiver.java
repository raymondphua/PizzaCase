package events;

import javax.enterprise.event.Observes;

/**
 * Created by Raymond Phua on 15-11-2016.
 */
public class GreetingsReceiver implements EventReceiver {

    private String greet = "Welcome";

    void receive(@Observes String greet) {
        this.greet = greet;
    }

    @Override
    public String getGreet() {
        return greet;
    }
}

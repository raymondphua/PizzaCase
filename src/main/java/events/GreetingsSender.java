package events;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by Raymond Phua on 15-11-2016.
 */
public class GreetingsSender implements EventSender, Serializable {

    @Inject
    private Event<String> event;

    @Override
    public void send(String message) {
        event.fire(message);
    }
}

package socket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by Raymond Phua on 15-11-2016.
 */
@ServerEndpoint("/socket")
public class Websocket {

    @OnOpen
    public void open (Session session) throws IOException {
        System.out.println("Session opened");
        session.getBasicRemote().sendText("Connection established");
    }

    @OnClose
    public void close(Session session) {
        System.out.println("Session " +session.getId()+" has ended");
    }

    @OnError
    public void onError(Throwable error) {}

    @OnMessage
    public void handleMessage(String message, Session session) throws IOException {
        System.out.println("Message from " + session.getId() + ": " + message);
        session.getBasicRemote().sendText(message);
    }
}

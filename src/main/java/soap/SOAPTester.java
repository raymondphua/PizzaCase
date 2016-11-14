package soap;

import javax.xml.ws.Endpoint;

/**
 * Created by Raymond Phua on 10-11-2016.
 */
public class SOAPTester {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws", new PizzaImpl());
    }
}

/**
 * Created by Raymond Phua on 14-11-2016.
 */

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

//@RunWith(Arquillian.class)
public class GreeterTest {

//    @Inject
//    Greeter greeter;
//
//    @Deployment
//    public static JavaArchive createDeployment() {
//        return ShrinkWrap.create(JavaArchive.class)
//                .addClass(Greeter.class)
//                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//    }
//
//    @Test
//    public void should_create_greeting() {
//        Assert.assertEquals("Hello, Earthling!",
//                greeter.createGreeting("Earthling"));
//        greeter.greet(System.out, "Earthling");
//    }

    @Test
    public void test() {
        //empty test
    }
}

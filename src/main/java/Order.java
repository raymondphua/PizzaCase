import enums.Status;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Random;

/**
 * Created by Raymond Phua on 27-10-2016.
 */
@Named
@ViewScoped
public class Order implements Serializable {

    private int orderNr;
    private String status;//Status status;

    public Order() {
        Random random = new Random();
        orderNr = random.nextInt(100);
        status = Status.PREPARING.toString();
    }

    public void updateStatus() {
        if (status == null) {
            this.status = Status.PREPARING.toString();
        } else if (status.equals(Status.PREPARING.toString())) {
            this.status = Status.DELIVERING.toString();
        } else if (status.equals(Status.DELIVERING.toString())) {
            this.status = Status.COMPLETED.toString();
        }
    }

    public void setOrderNr(int orderNr) {
        this.orderNr = orderNr;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

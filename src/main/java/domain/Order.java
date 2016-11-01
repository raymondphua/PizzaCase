package domain;

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
    private double statusProgress;

    public Order() {
        Random random = new Random();
        orderNr = random.nextInt(100);
        status = "Processing...";
    }

    public void updateStatus() {
        int statusSize = Status.values().length;
        double progressPercentage = 100.0 / statusSize;

        if (status.equals("Processing...")) {
            this.status = Status.PREPARING.toString();
            statusProgress = progressPercentage * 1;
        } else if (status.equals(Status.PREPARING.toString())) {
            this.status = Status.DELIVERING.toString();
            statusProgress = progressPercentage * 2;
        } else if (status.equals(Status.DELIVERING.toString())) {
            this.status = Status.COMPLETED.toString();
            statusProgress = progressPercentage * 3;
        }
    }

    public void setStatusProgress(double statusProgress) {
        this.statusProgress = statusProgress;
    }
    
    public double getStatusProgress() {
        
        return statusProgress;
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

package enums;

/**
 * Created by Raymond Phua on 28-10-2016.
 */
public enum Status {
    PREPARING, DELIVERING, COMPLETED;

    public String toString() {
        switch(this) {
            case PREPARING: return "Preparing";
            case DELIVERING: return "Delivering";
            case COMPLETED: return "Completed";
            default: return "Status...";
        }
    }
}

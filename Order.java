package UseCase8;

public class Order {
    private int orderID;
    private double totalPrice;

    public Order(int orderID, double totalPrice) {
        this.orderID = orderID;
        this.totalPrice = totalPrice;
    }
    public int getOrderID() {
        return orderID;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
}
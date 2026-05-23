package UseCase8;

public class ComplaintRequest {
    private int requestID;
    private String status;
    private int orderID;
    private double refundAmount;

    public ComplaintRequest(int id, int orderID, double amount) {
        this.requestID = id;
        this.status = "Εκκρεμής";
        this.orderID = orderID;
        this.refundAmount = amount;
    }
    public int getRequestID() {
        return requestID;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getOrderID() {
        return orderID;
    }
    public double getRefundAmount() {
        return refundAmount;
    }
}
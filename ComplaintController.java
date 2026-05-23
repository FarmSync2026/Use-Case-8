package UseCase8;

public class ComplaintController {
    private DBManager dbManager;
    public ComplaintController(DBManager dbManager) {
        this.dbManager = dbManager;
    }
    public ComplaintRequest reviewRequest(int requestId){
        return dbManager.getComplaintRequest(requestId);
    }
    public void requestEvidence(int requestId){
        System.out.println("Αποστολή ειδοποίησης για υποβολή αποδεικτικών (Αίτημα ID: " + requestId + ").");
    }
    public boolean processRefund(int requestId, double amount){
        dbManager.updateRequestStatus(requestId, "Εγκρίθηκε");
        UserProfile customer = dbManager.getUserProfile(10);
        UserProfile producer = dbManager.getUserProfile(20);
        if (customer != null && producer != null) {
            producer.adjustBalance(-amount);
            customer.adjustBalance(amount);
            return true;
        }
        return false;
    }
    public void rejectRequest(int requestId){
        dbManager.updateRequestStatus(requestId, "Απορρίφθηκε");
    }
}
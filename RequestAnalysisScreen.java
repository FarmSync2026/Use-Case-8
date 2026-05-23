package UseCase8;

public class RequestAnalysisScreen {
    public void displayAnalysis(ComplaintRequest complaintRequest) {
        System.out.println("Οθόνη Ανάλυσης Αιτήματος:");
        System.out.println("Στοιχεία Αιτήματος #" + complaintRequest.getRequestID());
        System.out.println("Σχετική Παραγγελία: #" + complaintRequest.getOrderID());
        System.out.println("Αιτούμενο Ποσό: " + complaintRequest.getRefundAmount() + "€");
        System.out.println("Τρέχουσα Κατάσταση: " + complaintRequest.getStatus());
    }
}

package UseCase8;

public class Main {
    public static void main(String[] args) {
        //Αρχικοποιήσεις
        DBManager dbManager = new DBManager();
        ComplaintController controller = new ComplaintController(dbManager);
        RequestDisplayScreen displayScreen = new RequestDisplayScreen();
        RequestAnalysisScreen analysisScreen = new RequestAnalysisScreen();
        EvidenceRequestAndDisplayScreen evidenceScreen = new EvidenceRequestAndDisplayScreen();
        CommunicationScreen communicationScreen = new CommunicationScreen();
        CustomerNotificationScreen successNotification = new CustomerNotificationScreen();
        NonApprovalNotificationScreen rejectionNotification = new NonApprovalNotificationScreen();

        //Βασική ροή
        displayScreen.show();
        ComplaintRequest request1 = controller.reviewRequest(501);
        analysisScreen.displayAnalysis(request1);
        evidenceScreen.displayEvidenceForm();
        controller.requestEvidence(request1.getRequestID());
        communicationScreen.openCommunicationChannel();
        System.out.println("Ο παραγωγός συμφώνησε στην επιστροφή");
        boolean isRefunded = controller.processRefund(request1.getRequestID(), request1.getRefundAmount());
        if (isRefunded) {
            successNotification.notifyCustomer("Τα χρήματά σας: " + request1.getRefundAmount() + "€ επιστράφηκαν επιτυχώς!");
            System.out.println("Νέα κατάσταση αιτήματος: " + request1.getStatus());
        }
        //Εναλλακτική ροή
        ComplaintRequest  request2 = controller.reviewRequest(502);
        analysisScreen.displayAnalysis(request2);
        communicationScreen.openCommunicationChannel();
        System.out.println("Ο παραγωγός αρνήθηκε την επιστροφή. Τα στοιχεία δεν επαρκούν.");
        controller.rejectRequest(request2.getRequestID());
        rejectionNotification.notifyNonApproval();
        System.out.println("Νέα κατάσταση αιτήματος: " + request2.getStatus());
    }
}
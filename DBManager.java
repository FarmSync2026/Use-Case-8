package UseCase8;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private List<ComplaintRequest> requests;
    private List<UserProfile> users;

    public DBManager() {
        requests = new ArrayList<>();
        users = new ArrayList<>();
        requests.add(new ComplaintRequest(501, 101, 25.00));
        requests.add(new ComplaintRequest(502, 102, 40.00));
        users.add(new UserProfile(10, "Πελάτης", 100.00));
        users.add(new UserProfile(20, "Παραγωγός", 500.00));
    }
    public ComplaintRequest getComplaintRequest(int id) {
        for (ComplaintRequest request : requests) {
            if (request.getRequestID() == id) {
                return request;
            }
        }
        return null;
    }
    public void updateRequestStatus(int id, String status) {
        ComplaintRequest request = getComplaintRequest(id);
        if (request != null) {
            request.setStatus(status);
        }
    }
    public UserProfile getUserProfile(int id) {
        for (UserProfile user : users) {
            if (user.getUserID() == id) {
                return user;
            }
        }
        return null;
    }
}

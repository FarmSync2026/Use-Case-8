package UseCase8;

public class UserProfile {
    private int userID;
    private String role;
    private double balance;

    public UserProfile(int userID, String role, double balance) {
        this.userID = userID;
        this.role = role;
        this.balance = balance;
    }
    public void adjustBalance(double balance){
        this.balance += balance;
    }
    public int getUserID() {
        return userID;
    }
    public String getRole() {
        return role;
    }
    public double getBalance() {
        return balance;
    }
}
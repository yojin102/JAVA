package model;
public class Admin {
    private String userID;
    private String userPW;

    public Admin(String userID, String userPW) {
        this.userID = userID;
        this.userPW = userPW;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserPW() {
        return userPW;
    }
}
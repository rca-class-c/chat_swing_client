package models;

import java.io.Serializable;

public class ActiveUser implements  Serializable{

    /**
     * it is highly recommended that each class declares its serialVersionUID
     * as the generated one is compiler dependent and thus may result in
     * unexpected InvalidClassExceptions.
     */
    private static final long serialVersionUID = 1L;

    int userID;
    String username;

    public ActiveUser(int userID, String username) {
        this.userID = userID;
        this.username = username;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

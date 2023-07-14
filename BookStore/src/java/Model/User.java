package model;

public class User {

    private int userID;
    private String name;
    private String username;
    private String password;
    private int Rollno;
    private String Address;

    public User() {
    }

    public User(int userID, String name, String username, String password, int Rollno, String Address) {
        this.userID = userID;
        this.name = name;
        this.username = username;
        this.password = password;
        this.Rollno = Rollno;
        this.Address = Address;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public User(int userID, String username, String password, int Rollno) {
        this.username = username;
        this.password = password;
        this.Rollno = Rollno;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRollno() {
        return Rollno;
    }

    public void setRollno(int Rollno) {
        this.Rollno = Rollno;
    }

}

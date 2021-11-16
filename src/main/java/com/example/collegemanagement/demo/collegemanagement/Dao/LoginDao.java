package com.example.collegemanagement.demo.collegemanagement.Dao;

public class LoginDao {
    int userId;
    String userName;
    String password;

    public int getUserId() {
        return userId;
    }

    public LoginDao(int userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.twu.biblioteca;

public class UserAccount{
    private int bibliotecaId;
    private String password;
    private String userName;
    private String userEmail;
    private String userPhone;


    public UserAccount(int bibliotecaId,
                       String password,
                       String userName,
                       String userEmail,
                       String userPhone) {
        this.bibliotecaId = bibliotecaId;
        this.password = password;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

    public int getBibliotecaId() {
        return bibliotecaId;
    }

    public void setBibliotecaId(int bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
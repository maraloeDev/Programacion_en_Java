package com.maraloedev.clases;


public class Usuario {
    
    private int idUser;
    private String login;
    private String password;
    private int bocked;

    public Usuario(int idUser, String login, String password, int bocked) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.bocked = bocked;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBocked() {
        return bocked;
    }

    public void setBocked(int bocked) {
        this.bocked = bocked;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUser=" + idUser + ", login=" + login + ", password=" + password + ", bocked=" + bocked + '}';
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maraloedev.clases;

/**
 *
 * @author Eduardo
 */
public class Usuario {
    
    private int id_user;
    private String login;
    private String passowrd;
    private boolean blocked;

    public Usuario(int id_user, String login, String passowrd, boolean blocked) {
        this.id_user = id_user;
        this.login = login;
        this.passowrd = passowrd;
        this.blocked = blocked;
    }
    
    public Usuario(String login, String passowrd) {
        this.id_user = id_user;
        this.login = login;
        this.passowrd = passowrd;
        this.blocked = blocked;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_user=" + id_user + ", login=" + login + ", passowrd=" + passowrd + ", blocked=" + blocked + '}';
    }
    
    
    
}

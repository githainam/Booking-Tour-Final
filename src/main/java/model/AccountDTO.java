/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hi
 */
public class AccountDTO {

    private int id;
    private String username, password, email, phone, avatar;
    private int role;

    public AccountDTO() {
    }

    public AccountDTO(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public AccountDTO(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    public AccountDTO(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public AccountDTO(int id, String username, String password, String email, String phone, int role, String avatar) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.avatar = avatar;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}

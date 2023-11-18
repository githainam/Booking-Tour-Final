/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class BookTour extends Tour {

    private int orderId;
    private int user_id;
    private String phone;
    private String email;
    private String address;
    private String note;
    private int quantityAd;
    private int quantityChildren;
    private String date;
    private String name;
    private float totalAmount;

    public BookTour() {
    }

    public BookTour(int user_id, String phone, String email, String address, String note, int quantityAd, int quantityChildren, String date, String name) {
        this.user_id = user_id;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.note = note;
        this.quantityAd = quantityAd;
        this.quantityChildren = quantityChildren;
        this.date = date;
        this.name = name;
    }

    public BookTour(int orderId, int user_id, String phone, String email, String address, String note, int quantityAd, int quantityChildren, String date, String name, float totalAmount) {
        this.orderId = orderId;
        this.user_id = user_id;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.note = note;
        this.quantityAd = quantityAd;
        this.quantityChildren = quantityChildren;
        this.date = date;
        this.name = name;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getQuantityAd() {
        return quantityAd;
    }

    public void setQuantityAd(int quantityAd) {
        this.quantityAd = quantityAd;
    }

    public int getQuantityChildren() {
        return quantityChildren;
    }

    public void setQuantityChildren(int quantityChildren) {
        this.quantityChildren = quantityChildren;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

}

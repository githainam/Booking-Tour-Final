/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import lombok.Getter;
import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author DELL
 */
public class Feedback {

    private int id;
    private String username;
    private int rated_star;
    private String feedback;
    private int tourId;
    private int u_id;
    private Date date;
    private String tourName;
    private String email;
    private String phone;
    private String avatar;

    public Feedback() {
    }

    public Feedback(int id, String username, int rated_star, String feedback, int tourId, int u_id, Date date, String avatar) {
        this.id = id;
        this.username = username;
        this.rated_star = rated_star;
        this.feedback = feedback;
        this.tourId = tourId;
        this.u_id = u_id;
        this.date = date;
        this.avatar = avatar;

    }

    public Feedback(int id, String username, int rated_star, String feedback,  int tourId, int u_id, Date date, String tourName, String email, String phone, String avatar) {
        this.id = id;
        this.username = username;
        this.rated_star = rated_star;
        this.feedback = feedback;
        this.tourId = tourId;
        this.u_id = u_id;
        this.date = date;
        this.tourName = tourName;
        this.email = email;
        this.phone = phone;
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

    public int getRated_star() {
        return rated_star;
    }

    public void setRated_star(int rated_star) {
        this.rated_star = rated_star;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }



    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;


/**
 *
 * @author DELL
 */
public class Blog {

    private int blog_id;
    private String title;
    private int author_id;
    private Date updated_date;
    private String content;
    private String thumbnail;
    private String brief_infor;
    private boolean status;

  

    public Blog() {
    }

    public Blog(int blog_id, String title, int author_id, Date updated_date, String content, String thumbnail, String brief_infor,  boolean status) {
        this.blog_id = blog_id;
        this.title = title;
        this.author_id = author_id;
        this.updated_date = updated_date;
        this.content = content;
        this.thumbnail = thumbnail;
        this.brief_infor = brief_infor;
        this.status = status;
    }

    public Blog(int blog_id, String title, int author_id, Date updated_date, String content, String thumbnail, String brief_infor) {
        this.blog_id = blog_id;
        this.title = title;
        this.author_id = author_id;
        this.updated_date = updated_date;
        this.content = content;
        this.thumbnail = thumbnail;
        this.brief_infor = brief_infor;
    }
    

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getBrief_infor() {
        return brief_infor;
    }

    public void setBrief_infor(String brief_infor) {
        this.brief_infor = brief_infor;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
}

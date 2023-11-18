/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class Region {
    
    private int regionId;
    private String regionName;
    private String regionImage;
    private String regionDetail;

    public Region(int regionId, String regionName, String regionImage, String regionDetail) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.regionImage = regionImage;
        this.regionDetail = regionDetail;
    }

    public Region() {
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionImage() {
        return regionImage;
    }

    public void setRegionImage(String regionImage) {
        this.regionImage = regionImage;
    }

    public String getRegionDetail() {
        return regionDetail;
    }

    public void setRegionDetail(String regionDetail) {
        this.regionDetail = regionDetail;
    }
    
    
}

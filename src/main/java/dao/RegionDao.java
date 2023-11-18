/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Region;

/**
 *
 * @author DELL
 */
public class RegionDao {

    private Connection con;

    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public RegionDao(Connection con) {
        this.con = con;
    }

    public RegionDao() {
    }

    public List<Region> getAllRegions() {

        List<Region> regions = new ArrayList<Region>();
        try {

            query = "SELECT * from region";

            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Region row = new Region();
                row.setRegionName(rs.getString("regionName"));
                row.setRegionId(rs.getInt("regionId"));
                row.setRegionImage(rs.getString("regionImage"));
                row.setRegionDetail(rs.getString("regionDetail"));

                regions.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return regions;
    }

    
}

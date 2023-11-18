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
import model.Place;
import model.Region;

/**
 *
 * @author DELL
 */
public class PlaceDao {

    private Connection con;

    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public PlaceDao(Connection con) {
        this.con = con;
    }

    public PlaceDao() {
    }

    public List<Place> getAllPlaces() {

        List<Place> places = new ArrayList<Place>();
        try {

            query = "SELECT * from place";

            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Place row = new Place();
                row.setPlaceName(rs.getString("placeName"));
                row.setPlaceId(rs.getInt("placeId"));


                places.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return places;
    }

    
}


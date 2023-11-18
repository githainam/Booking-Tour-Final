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
import model.BookTour;
import model.Tour;
import java.text.DecimalFormat;

/**
 *
 * @author DELL
 */
public class OrderDao {

    private Connection con;

    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public OrderDao(Connection con) {
        this.con = con;
    }

    public OrderDao() {
    }

    public List<BookTour> userOrders(int id) {
        List<BookTour> list = new ArrayList<>();
        try {
            query = "select * from bookTour where u_id=? order by bookTour.t_id desc";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                BookTour order = new BookTour();
                TourDao tourDao = new TourDao(this.con);
                int tId = rs.getInt("t_id");
                Tour tour = tourDao.getSingleTour(tId);
                order.setOrderId(rs.getInt("o_id"));
                order.setTourId(tId);
                order.setTourName(tour.getTourName());
                order.setDateStart(tour.getDateStart());
                order.setPrice(tour.getPrice() * rs.getInt("book_quantityAd"));
                order.setQuantityAd(rs.getInt("book_quantityChild"));
                order.setQuantityChildren(rs.getInt("book_quantityChild"));
                order.setDate(rs.getString("book_date"));
                order.setAddress(rs.getString("book_address"));
                order.setName(rs.getString("book_cusName"));
                order.setNote(rs.getString("note"));
                order.setEmail(rs.getString("book_email"));
                order.setPhone(rs.getString("book_phone"));

                // Calculate and set the total amount
                float adultPrice = order.getPrice();
                float childrenPrice = adultPrice / 2;
                float totalAmount = (adultPrice * order.getQuantityAd()) + (childrenPrice * order.getQuantityChildren());
                order.setTotalAmount(totalAmount);

                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public boolean insertOrder(BookTour model) {
        boolean result = false;
        try {
            query = "insert into bookTour(t_id, u_id, book_date, book_cusName, book_address, book_phone,\n"
                    + "book_email, book_quantityAd, book_quantityChild, note, total_amount)\n"
                    + "values(?,?,?,?,?,?,?,?,?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, model.getOrderId());
            pst.setInt(2, model.getUser_id());
            pst.setString(3, model.getDate());
            pst.setString(4, model.getName());
            pst.setString(5, model.getAddress());
            pst.setString(6, model.getPhone());
            pst.setString(7, model.getEmail());
            pst.setInt(8, model.getQuantityAd());
            pst.setInt(9, model.getQuantityChildren());
            pst.setString(10, model.getNote());
            pst.setFloat(11, model.getTotalAmount());

            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
}

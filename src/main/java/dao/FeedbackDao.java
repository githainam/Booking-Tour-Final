package dao;

import connection.DbCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Feedback;
import model.Tour;

public class FeedbackDao {

    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    public List<Feedback> getAllFeedbackByProductId(int id) throws ClassNotFoundException {
        List<Feedback> list = new ArrayList<>();
        String sql = "SELECT * FROM feedbackTour WHERE tourId = ?";
        try {
            con = DbCon.getConnection();
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                Feedback f = new Feedback();
                f.setId(rs.getInt("feedback_id"));
                f.setUsername(rs.getString("username"));
                f.setRated_star(rs.getInt("rated_star"));
                f.setFeedback(rs.getString("feedback"));
                f.setTourId(rs.getInt("tourId"));
                f.setU_id(rs.getInt("u_id"));
                f.setDate(rs.getDate("date"));
                f.setAvatar(rs.getString("avatar"));

                list.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public int getTotalFeedback(int id) throws ClassNotFoundException {
        String sql = "SELECT COUNT(feedback_id) FROM feedbackTour WHERE tourId = ?";
        try {
            con = DbCon.getConnection();
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public void addNewFeedback(String username, int star, String subject, int tourId, int u_id, Date date, String avatar) throws ClassNotFoundException {
        try {
            String sql = "INSERT INTO [dbo].[feedbackTour] ([username], [rated_star], [feedback], [tourId], [u_id], [date], [avatar]) VALUES (?, ?, ?, ?, ?, ?, ?)";
            con = DbCon.getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, username);
            st.setInt(2, star);
            st.setString(3, subject);
            st.setInt(4, tourId);
            st.setInt(5, u_id);
            st.setDate(6, new java.sql.Date(date.getTime()));
            st.setString(7, avatar);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteFeedbacktById(int id) throws ClassNotFoundException {
        String sql = "DELETE FROM [dbo].[feedbackTour]\n"
                + "      WHERE feedBack_id = ?";
        try {
            con = DbCon.getConnection();
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editFeedbacktById(int id, int star, String subject, int tourId, int u_id, Date date) throws ClassNotFoundException {
        try {
            String sql = "UPDATE [dbo].[feedbackTour]\n"
                    + "SET\n"
                    + "[rated_star] = ?\n"
                    + ",[feedback] = ?\n"
                    + ",[date] = ?\n"
                    + "WHERE [feedback_id] = ?";
            con = DbCon.getConnection();
            st = con.prepareStatement(sql);
            st.setInt(1, star);
            st.setString(2, subject);
            st.setDate(3, new java.sql.Date(date.getTime()));
            st.setInt(4, tourId);

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public Feedback getSingleFeedbackById(int id) {
        Feedback row = null;
        try {
            String sql = "select * from feedbackTour where feedback_id=? ";

             con = DbCon.getConnection();
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                row = new Feedback();
                row.setTourId(rs.getInt("tourId"));
                row.setFeedback(rs.getString("subject"));
                row.setRated_star(rs.getInt("rated_star"));
                row.setU_id(rs.getInt("u_id"));
                row.setUsername(rs.getString("username"));

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return row;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DbCon;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Blog;
//import model.CategoryBlog;
//import model.Chart;
//import model.Product;

/**
 *
 * @author Admin
 */
public class BlogDAO {

    private Connection con;

    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public BlogDAO(Connection con) {
        this.con = con;
    }

    public BlogDAO() {
    }

    public List<Blog> getAllBlog() {
        List<Blog> list = new ArrayList<>();
        try {
            query = "SELECT * FROM Blog ";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                int blog_id = rs.getInt("blog_id");
                String title = rs.getString("title");
                int author_id = rs.getInt("author_id");
                Date updated_date = rs.getDate("updated_date");
                String content = rs.getString("content");
                String thumbnail = rs.getString("thumbnail");
                String brief_infor = rs.getString("brief_infor");

                Blog c = new Blog(blog_id, title, author_id, updated_date, content, thumbnail, brief_infor);
                list.add(c);
            }
        } catch (SQLException e) {
            // Xử lý lỗi, ví dụ:
            e.printStackTrace();
        }
        return list;
    }

    public Blog getBlogByBlogId(int blog_id) {
        String sql = "SELECT * FROM Blog WHERE blog_id = ?";
        try {

            this.con = DbCon.getConnection();

            pst = this.con.prepareStatement(sql);
            pst.setInt(1, blog_id);
            rs = pst.executeQuery();
            if (rs.next()) {

                blog_id = rs.getInt("blog_id");
                String title = rs.getString("title");
                int authorId = rs.getInt("author_id");
                Date updated_date = rs.getDate("updated_date");
                String content = rs.getString("content");
                String thumbnail = rs.getString("thumbnail");
                String briefInfo = rs.getString("brief_infor");
                boolean status = rs.getBoolean("status");

                Blog c = new Blog(blog_id, title, authorId, updated_date, content, thumbnail, briefInfo, status);
                return c;
            }
        } catch (SQLException e) {
            // Xử lý lỗi, ví dụ:
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    public Blog getBlogNew() {
//        List<Blog> list = new ArrayList<>();
//        String sql = "select top 1 * from Blog where status = 1\n"
//                + "order by updated_date desc";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                int blog_id = rs.getInt("blog_id");
//                String title = rs.getString("title");
//                int authorId = rs.getInt("author_id");
//                Date updated_date = rs.getDate("updated_date");
//                String content = rs.getString("content");
//                String thumbnail = rs.getString("thumbnail");
//                String briefInfo = rs.getString("brief_infor");
//                boolean status = rs.getBoolean("status");
//
//                Blog c = new Blog(blog_id, title, authorId, updated_date, content, thumbnail, briefInfo, status);
//                return c;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//    }
//
//    public void addNewBlog(String title, int user_id, String content, String brief_infor, int status, String url_thumbnail) {
//        try {
//            String sql = "INSERT INTO [dbo].[Blog]\n"
//                    + "           ([title]\n"
//                    + "           ,[author_id]\n"
//                    + "           ,[content]\n"
//                    + "           ,[thumbnail]\n"
//                    + "           ,[brief_infor]\n"
//                    + "           ,[status])\n"
//                    + "     VALUES\n"
//                    + "           (?,?,?,?,?,?,?)";
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, title);
//            st.setInt(2, user_id);
//            st.setString(3, content);
//            st.setString(4, url_thumbnail);
//            st.setString(5, brief_infor);
//            st.setInt(6, status);
//
//            st.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
//
//    public void UpdateBlogById(String title, int user_id, String content, String brief_infor, int status, String url_thumbnail, int blog_id) {
//        try {
//            String sql = "UPDATE [dbo].[Blog]\n"
//                    + "   SET [title] = ?\n"
//                    + "      ,[author_id] = ?\n"
//                    + "      ,[updated_date] = getdate()\n"
//                    + "      ,[content] = ?\n"
//                    + "      ,[thumbnail] = ?\n"
//                    + "      ,[brief_infor] = ?\n"
//                    + "      ,[status] = ?\n"
//                    + " WHERE blog_id = ?";
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, title);
//            st.setInt(2, user_id);
//            st.setString(3, content);
//            st.setString(4, url_thumbnail);
//            st.setString(5, brief_infor);
//            st.setInt(6, status);
//            st.setInt(7, blog_id);
//
//            st.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
//
//    public void changeStatusById(int blog_id, int status) {
//        try {
//            String sql = "UPDATE [dbo].[Blog]\n"
//                    + "   SET [status] = ?\n"
//                    + " WHERE blog_id = ?";
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, status);
//            st.setInt(2, blog_id);
//
//            st.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }

//    public List<Chart> getChartBlogBar(String start, int day) {
//        List<Chart> list = new ArrayList<>();
//        for (int i = 0; i < day; i++) {
//            int value = 0;
//            String sql = "select count(*) from Blog where updated_date = DATEADD(DAY, ?, ?) and status = 1";
//            try {
//                PreparedStatement st = connection.prepareStatement(sql);
//                st.setInt(1, i);
//                st.setString(2, start);
//                ResultSet rs = st.executeQuery();
//                while (rs.next()) {
//                    value = rs.getInt(1);
//                }
//                sql = "select  DATEADD(DAY, ?, ?)";
//                st = connection.prepareStatement(sql);
//                st.setInt(1, i);
//                st.setString(2, start);
//                rs = st.executeQuery();
//                while (rs.next()) {
//                    Chart c = Chart.builder()
//                            .date(rs.getDate(1))
//                            .value(value)
//                            .build();
//                    list.add(c);
//                }
//
//            } catch (SQLException e) {
//                System.out.println(e);
//            }
//        }
//
//        return list;
//    }
//    public List<Chart> getChartBlogArea(String start, int day) {
//        List<Chart> list = new ArrayList<>();
//        for (int i = 0; i < day; i++) {
//            int value = 0;
//            String sql = "select count(*) from Blog where updated_date <= DATEADD(DAY, ?, ?) and status = 1";
//            try {
//                PreparedStatement st = connection.prepareStatement(sql);
//                st.setInt(1, i);
//                st.setString(2, start);
//                ResultSet rs = st.executeQuery();
//                while (rs.next()) {
//                    value = rs.getInt(1);
//                }
//                sql = "select  DATEADD(DAY, ?, ?)";
//                st = connection.prepareStatement(sql);
//                st.setInt(1, i);
//                st.setString(2, start);
//                rs = st.executeQuery();
//                while (rs.next()) {
//                    Chart c = Chart.builder()
//                            .date(rs.getDate(1))
//                            .value(value)
//                            .build();
//                    list.add(c);
//                }
//
//            } catch (SQLException e) {
//                System.out.println(e);
//            }
//        }
//
//        return list;
    //    }
//    public String getUrlImageById(int id) {
//        String sql = "select thumbnail from Blog where blog_id = ?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//
//                return rs.getString(1);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//    }

}

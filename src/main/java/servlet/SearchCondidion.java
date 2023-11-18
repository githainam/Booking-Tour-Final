/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import connection.DbCon;
import dao.BlogDAO;
import dao.TourDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Blog;
import model.Tour;
import model.TourSchedule;

/**
 *
 * @author DELL
 */
public class SearchCondidion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchCondidion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchCondidion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String regionSearch = request.getParameter("regionSearch");
            String placeSearch = request.getParameter("placeSearch");
            String dateStartSearch = request.getParameter("dateStartSearch");

            TourDao r = new TourDao(DbCon.getConnection());
            List<Tour> searchResults = r.searchTours(regionSearch, placeSearch, dateStartSearch);

            // Đưa kết quả tìm kiếm vào attribute của request để hiển thị trên view
            request.setAttribute("listS", searchResults);

            // Forward yêu cầu đến trang kết quả tìm kiếm
            request.getRequestDispatcher("searchResult.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchCondidion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchCondidion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

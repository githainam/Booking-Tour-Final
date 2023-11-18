/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import connection.DbCon;
import dao.OrderDao;
import dao.TourDao;
import jakarta.mail.MessagingException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AccountDTO;
import model.BookTour;
import model.EmailSender;
import model.Tour;
import model.TourSchedule;

/**
 *
 * @author DELL
 */
public class BookingServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookingServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int adults = Integer.parseInt(request.getParameter("adults"));
        int children = Integer.parseInt(request.getParameter("children"));
        String note = request.getParameter("note");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        AccountDTO acc = (AccountDTO) request.getSession().getAttribute("acc");

        if (acc != null) {
            try {
                request.setAttribute("acc", acc);
                String tourId = request.getParameter("id");
                BookTour orderModel = new BookTour();
                orderModel.setOrderId(Integer.parseInt(tourId));
                orderModel.setUser_id(acc.getId());
                orderModel.setQuantityAd(adults);
                orderModel.setQuantityChildren(children);
                orderModel.setAddress(address);
                orderModel.setName(fullName);
                orderModel.setPhone(phone);
                orderModel.setEmail(email);
                orderModel.setNote(note);
                orderModel.setDate(formatter.format(date));

                // Calculate and set the total amount
                TourDao tourDao = new TourDao(DbCon.getConnection());
                int tId = Integer.parseInt(tourId);
                Tour tour = tourDao.getSingleTour(tId);
                float adultPrice = tour.getPrice();
                float childrenPrice = adultPrice / 2;
                float totalAmount = (adultPrice * adults) + (childrenPrice * children);
                orderModel.setTotalAmount(totalAmount);

                // Insert the order into the database
                OrderDao orderDao = new OrderDao(DbCon.getConnection());
                boolean result = orderDao.insertOrder(orderModel);

                if (result) {
                    // Update the remaining seats in the tour
                    int remainingSeats = tour.getSeat();
                    remainingSeats -= (adults + children);
                    tour.setSeat(remainingSeats);
                    tourDao.updateTour(tour);

                    EmailSender.sendConfirmationEmail(email, orderModel, tour);
                    request.getRequestDispatcher("orderNoti.jsp").forward(request, response);
                } else {
                    response.getWriter().println("Order failed");
                }
                return;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BookingServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(BookingServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
                Logger.getLogger(BookingServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Người dùng chưa đăng nhập, chuyển hướng đến trang đăng nhập
            response.sendRedirect("Login");
            return;
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.FeedbackDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AccountDTO;
import java.util.Date;
import java.util.List;
import model.Feedback;

/**
 *
 * @author DELL
 */
public class EditFeedbackServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try ( PrintWriter out = response.getWriter()) {
            AccountDTO acc = (AccountDTO) session.getAttribute("acc");
            String historyUrl = (String) session.getAttribute("historyUrl");
            int id = Integer.parseInt(request.getParameter("id"));
            int tourId = Integer.parseInt(request.getParameter("tid"));

            String subject = request.getParameter("subject");
            int star = Integer.parseInt(request.getParameter("star"));
            FeedbackDao fd = new FeedbackDao();
            Feedback update = fd.getSingleFeedbackById(id);
            request.setAttribute("update", update);

            fd.editFeedbacktById(id, star, subject, tourId, acc.getId(), date);
            response.sendRedirect(historyUrl);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditFeedbackServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
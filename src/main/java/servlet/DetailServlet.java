/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.FeedbackDao;
import dao.TourDao;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AccountDTO;
import model.Feedback;
import model.Tour;

/**
 *
 * @author DELL
 */
public class DetailServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        HttpSession session = request.getSession();

        AccountDTO acc = (AccountDTO) session.getAttribute("acc");
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("tid"));

        TourDao dao = new TourDao();
        FeedbackDao fed = new FeedbackDao();

        Tour t = dao.getTourByID(id);
        List<Tour> tourRelated = dao.getTop4();
        int Total = fed.getTotalFeedback(id);
        List<Feedback> listfeedbackbyproduct = fed.getAllFeedbackByProductId(id);


        request.getServletContext().setAttribute("tRelated", tourRelated);
        request.setAttribute("total", Total);

        request.setAttribute("detail", t);
        session.setAttribute("historyUrl", "detail?tid=" + id);
        request.setAttribute("listfeedbackbyproduct", listfeedbackbyproduct);
        request.getRequestDispatcher("single.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DetailServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

package servlet;

import connection.DbCon;
import dao.PlaceDao;
import dao.TourDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Region;
import dao.RegionDao;
import model.Place;
import model.Tour;

public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            TourDao t = new TourDao(DbCon.getConnection());
            RegionDao r = new RegionDao(DbCon.getConnection());
            PlaceDao p = new PlaceDao(DbCon.getConnection());

            List<Tour> tours = t.getAllTours();
            List<Region> regions = r.getAllRegions();
            List<Place> places = p.getAllPlaces();

            int tourCount = t.getAllToursCount();

            request.getServletContext().setAttribute("myTours", tours);
            request.getServletContext().setAttribute("myRegions", regions);
            request.getServletContext().setAttribute("myPlaces", places);

            request.setAttribute("tourCount", tourCount);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

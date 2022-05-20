package com.example.t4hback.web;

import com.example.t4hback.dao.HousingDAO;
import com.example.t4hback.dao.RentDao;
import com.example.t4hback.dao.UserDAO;
import com.example.t4hback.model.Housing;
import com.example.t4hback.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet(name = "HousingPageServlet", value = "/housing_page")
public class HousingPageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HousingDAO housingDAO;
    private UserDAO userDAO;
    private RentDao rentDAO;

    public void init() {
        housingDAO = new HousingDAO();
        userDAO = new UserDAO();
        rentDAO = new RentDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            this.selectHousing(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void selectHousing(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Integer hid = Integer.parseInt(request.getParameter("hid"));
        Housing resultHousing = housingDAO.selectHousingByHousingID(hid);
        Integer oid = resultHousing.getId_owner();
        User resultHousingOwner = userDAO.selectUser(oid);
        double rating = rentDAO.selectRatingByHousingID(hid);
        request.setAttribute("resultHousingOwner", resultHousingOwner);
        request.setAttribute("resultHousing", resultHousing);
        request.setAttribute("rating", rating);
        RequestDispatcher dispatcher = request.getRequestDispatcher("housing.jsp");
        dispatcher.forward(request, response);
    }

}

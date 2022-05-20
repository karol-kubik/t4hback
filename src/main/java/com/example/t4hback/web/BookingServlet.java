package com.example.t4hback.web;

import com.example.t4hback.dao.HousingDAO;
import com.example.t4hback.dao.RentDao;
import com.example.t4hback.model.Housing;
import com.example.t4hback.model.Rent;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "bookingServlet", value = "/send_booking")
public class BookingServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private HousingDAO housingDAO;
    private RentDao rentDAO;

    public void init() {
        housingDAO = new HousingDAO();
        rentDAO = new RentDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            this.insertBooking(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertBooking(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        Integer id_owner = Integer.valueOf(request.getParameter("id_owner"));
        Integer id_housing = Integer.valueOf(request.getParameter("id_housing"));
        Integer id_guest = Integer.valueOf(request.getParameter("gid"));
        String state = "requested"; //Requested, validated, rejected, ended
        Integer eval = null;
        String comment = "";
        Rent newRent = new Rent(id_guest, id_owner, id_housing, startDate, endDate, state, eval, comment);
        rentDAO.insertRent(newRent);
        response.sendRedirect("index.jsp");
    }

}

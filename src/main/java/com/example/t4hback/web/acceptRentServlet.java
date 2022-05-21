package com.example.t4hback.web;

import com.example.t4hback.dao.HousingDAO;
import com.example.t4hback.dao.RentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "acceptRentServlet", value = "/accept_booking")
public class acceptRentServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private RentDao rentDAO;

    public void init() {
        rentDAO = new RentDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            this.acceptBooking(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void acceptBooking(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id_rent = Integer.parseInt(request.getParameter("rid"));
        rentDAO.acceptRent(id_rent);
        response.sendRedirect("my_bookings");

    }

}

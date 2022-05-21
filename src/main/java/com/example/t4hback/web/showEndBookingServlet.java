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
import java.sql.SQLException;

@WebServlet(name = "showEndBookingServlet", value = "/end_booking")
public class showEndBookingServlet extends javax.servlet.http.HttpServlet {
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
            this.showEndBookingForm(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showEndBookingForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id_rent = Integer.parseInt(request.getParameter("rid"));
        Rent rent = rentDAO.selectRentByRentID(id_rent);
        System.out.println("ID RENT = " + rent.getId_rent());
        request.setAttribute("rent", rent);
        RequestDispatcher dispatcherBooking = request.getRequestDispatcher("endBookingForm.jsp");
        dispatcherBooking.forward(request, response);

    }

}

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
import java.util.List;

@WebServlet(name = "listUserBookingsServlet", value = "/my_bookings")
public class listUserBookingServlet extends javax.servlet.http.HttpServlet {
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
            this.listRentsByUID(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listRentsByUID(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        Integer uid = (Integer) session.getAttribute("id");
        List<Rent> listOwnerRents = rentDAO.selectRentsByOwner(uid);
        request.setAttribute("listOwnerRents", listOwnerRents);
        List<Rent> listGuestRents = rentDAO.selectRentsByGuest(uid);
        request.setAttribute("listGuestRents", listGuestRents);
        RequestDispatcher dispatcherHousing = request.getRequestDispatcher("userBookings.jsp");
        dispatcherHousing.forward(request, response);
    }

}

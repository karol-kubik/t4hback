package com.example.t4hback.web;

import com.example.t4hback.dao.HousingDAO;
import com.example.t4hback.dao.RentDao;
import com.example.t4hback.model.Housing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "showBookingServlet", value = "/book_housing")
public class showBookingServlet extends javax.servlet.http.HttpServlet {
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
            this.showBookingForm(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showBookingForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id_housing = Integer.parseInt(request.getParameter("hid"));
        Housing bookingHousing = housingDAO.selectHousingByHousingID(id_housing);
        HttpSession session = request.getSession();
        Integer id_guest = (Integer) session.getAttribute("id"); //ATTENTION IL FAUT SE CONNECTER POUR POUVOIR FAIRE UN BOOKING
        request.setAttribute("housing", bookingHousing);
        request.setAttribute("gid",id_guest);
        System.out.println("ID guest" + id_guest);
        System.out.println("ID housing" + id_housing);
        System.out.println("ID owner" + bookingHousing.getId_owner());
        RequestDispatcher dispatcherBooking = request.getRequestDispatcher("booking-form.jsp");
        dispatcherBooking.forward(request, response);

    }

}

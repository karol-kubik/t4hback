package com.example.t4hback.web;

import com.example.t4hback.dao.HousingDAO;
import com.example.t4hback.dao.RentDao;
import com.example.t4hback.model.Housing;
import com.example.t4hback.model.Rent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "endBookingServlet", value = "/end_book")
public class endBookingServlet extends javax.servlet.http.HttpServlet {
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
            this.endBooking(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void endBooking(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Integer id_rent = Integer.parseInt(request.getParameter("id_rent"));
        Integer eval = Integer.parseInt(request.getParameter("eval"));
        String comment = request.getParameter("comment");
        System.out.println("Comment = " + comment);
        System.out.println("Eval = " + eval);
        System.out.println("Rent ID = " + id_rent);
        Rent closedRent = new Rent(id_rent, eval, comment);
        rentDAO.updateRentStateAndComment(closedRent);
        response.sendRedirect("account.jsp");
    }

}

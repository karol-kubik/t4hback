package com.example.t4hback.web;

import com.example.t4hback.dao.HousingDAO;
import com.example.t4hback.model.Housing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "deleteHousingServlet", value = "/delete_housing")
public class deleteHousingServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private HousingDAO housingDAO;

    public void init() {
        housingDAO = new HousingDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            this.deleteHousing(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteHousing(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id_housing = Integer.parseInt(request.getParameter("hid"));
        housingDAO.deleteHousing(id_housing);
        response.sendRedirect("account.jsp");

    }

}

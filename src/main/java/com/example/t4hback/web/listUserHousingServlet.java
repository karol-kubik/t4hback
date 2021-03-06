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

@WebServlet(name = "listUserHousingsServlet", value = "/my_housings")
public class listUserHousingServlet extends javax.servlet.http.HttpServlet {
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
            this.listHousingsByUID(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listHousingsByUID(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        Integer uid = (Integer) session.getAttribute("id");
        List<Housing> listHousing = housingDAO.selectHousingsByUID(uid);
        request.setAttribute("listHousing", listHousing);
        RequestDispatcher dispatcherHousing = request.getRequestDispatcher("userHousings.jsp");
        dispatcherHousing.forward(request, response);
    }

}

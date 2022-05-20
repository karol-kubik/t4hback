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

@WebServlet(name = "editHousingServlet", value = "/updateHousing")
public class editHousingServlet extends javax.servlet.http.HttpServlet {
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
            this.updateHousing(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateHousing(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Integer id_housing = Integer.parseInt(request.getParameter("id_housing"));
        Integer id_owner = Integer.parseInt(request.getParameter("id_owner"));
        String title = request.getParameter("title");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String description = request.getParameter("description");
        Boolean noSmoke = Boolean.valueOf(request.getParameter("noSmoke"));
        Boolean noiseCurfew = Boolean.valueOf(request.getParameter("noiseCurfew"));
        Boolean noChild = Boolean.valueOf(request.getParameter("noChild"));
        Boolean noPets = Boolean.valueOf(request.getParameter("noPets"));
        Boolean petKeep = Boolean.valueOf(request.getParameter("petKeep"));
        Boolean plantWater = Boolean.valueOf(request.getParameter("plantWater"));
        Boolean houseClean = Boolean.valueOf(request.getParameter("houseClean"));

        Housing updatedHousing = new Housing(id_housing, id_owner, title, address, city, description, noSmoke, noiseCurfew, noChild, noPets, petKeep, plantWater, houseClean);
        housingDAO.updateHousing(updatedHousing);
        response.sendRedirect("my_housings");
    }

}

package com.example.t4hback.web;

import com.example.t4hback.dao.HousingDAO;
import com.example.t4hback.model.Housing;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/housing")
public class HousingServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private HousingDAO housingDAO;

    public void init() {
        housingDAO = new HousingDAO();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new_housing":
                    this.showNewFormHousing(request, response);
                    break;
                case "/insert_housing":
                    this.insertHousing(request, response);
                    break;
                case "/delete_housing":
                    this.deleteHousing(request, response);
                    break;
                case "/edit_housing":
                    this.showEditFormHousing(request, response);
                    break;
                case "/update_housing":
                    this.updateHousing(request, response);
                    break;
                case "/list_housing":
                    System.out.println("Test housing");
                    this.listHousing(request, response);
                    break;
                default:
                    this.listHousing(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new javax.servlet.ServletException(ex);
        }
    }

    private void listHousing(javax.servlet.http.HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, javax.servlet.ServletException {
        List<Housing> listHousing = housingDAO.selectAllHousings();
        request.setAttribute("listHousing", listHousing);
        RequestDispatcher dispatcherHousing = request.getRequestDispatcher("housing-list.jsp");
        dispatcherHousing.forward(request, response);
    }

    private void showNewFormHousing(javax.servlet.http.HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        RequestDispatcher dispatcherHousing = request.getRequestDispatcher("housing-list.jsp");
        dispatcherHousing.forward(request, response);
    }

    private void showEditFormHousing(javax.servlet.http.HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id_housing = Integer.parseInt(request.getParameter("id_housing"));
        Housing existingHousing = housingDAO.selectHousingById(id_housing);
        RequestDispatcher dispatcherHousing = request.getRequestDispatcher("housing-form.jsp");
        request.setAttribute("housing", existingHousing);
        dispatcherHousing.forward(request, response);

    }

    private void insertHousing(javax.servlet.http.HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Integer id_owner = Integer.valueOf(request.getParameter("id_owner"));
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
        Housing newHousing = new Housing(id_owner, title, address, city, description, noSmoke, noiseCurfew, noChild, noPets, petKeep, plantWater, houseClean);
        housingDAO.insertHousing(newHousing);
        response.sendRedirect("list");
    }

    private void updateHousing(javax.servlet.http.HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id_housing = Integer.parseInt(request.getParameter("id_housing"));
        Integer id_owner = Integer.valueOf(request.getParameter("id_owner"));
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

        Housing book = new Housing(id_housing, id_owner, title, address, city, description, noSmoke, noiseCurfew, noChild, noPets, petKeep, plantWater, houseClean);
        housingDAO.updateHousing(book);
        response.sendRedirect("list");
    }

    private void deleteHousing(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id_housing = Integer.parseInt(request.getParameter("id_housing"));
        housingDAO.deleteHousing(id_housing);
        response.sendRedirect("list");

    }

}

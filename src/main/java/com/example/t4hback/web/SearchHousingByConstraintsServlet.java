package com.example.t4hback.web;

import com.example.t4hback.dao.HousingDAO;
import com.example.t4hback.dao.RentDao;
import com.example.t4hback.model.Housing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "searchHousingByConstraintsServlet", value = "/search_housing_constraints")
public class SearchHousingByConstraintsServlet extends javax.servlet.http.HttpServlet {
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
            this.searchHousingByConstraints(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void searchHousingByConstraints(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String resultNoSmoke = request.getParameter("noSmoke");
        String resultNoiseCurfew = request.getParameter("noiseCurfew");
        String resultNoChild = request.getParameter("noChild");
        String resultNoPets = request.getParameter("noPets");

        Boolean noSmoke = false;
        Boolean noiseCurfew = false;
        Boolean noChild = false;
        Boolean noPets = false;


        switch(resultNoSmoke){
            case "yes" :
                noSmoke = true;
                break;
            case "no":
                noSmoke = false;
                break;
        }

        switch(resultNoiseCurfew){
            case "yes" :
                noiseCurfew = true;
                break;
            case "no":
                noiseCurfew = false;
                break;
        }

        switch(resultNoChild){
            case "yes" :
                noChild = true;
                break;
            case "no":
                noChild = false;
                break;
        }

        switch(resultNoPets){
            case "yes" :
                noPets = true;
                break;
            case "no":
                noPets = false;
                break;
        }
        List<Housing> listHousing = housingDAO.selectHousingsByConstraints(noSmoke,noiseCurfew,noChild,noPets);
        request.setAttribute("listHousing", listHousing);
        RequestDispatcher dispatcherHousing = request.getRequestDispatcher("home.jsp");
        dispatcherHousing.forward(request, response);
    }

}

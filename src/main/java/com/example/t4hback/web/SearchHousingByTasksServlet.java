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

@WebServlet(name = "searchHousingByTasksServlet", value = "/search_housing_tasks")
public class SearchHousingByTasksServlet extends javax.servlet.http.HttpServlet {
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
        String resultPetKeep = request.getParameter("petKeep");
        String resultPlantWater = request.getParameter("plantWater");
        String resultHouseClean = request.getParameter("houseClean");

        Boolean petKeep = false;
        Boolean plantWater = false;
        Boolean houseClean = false;


        switch(resultPetKeep){
            case "yes" :
                petKeep = true;
                break;
            case "no":
                petKeep = false;
                break;
        }

        switch(resultPlantWater){
            case "yes" :
                plantWater = true;
                break;
            case "no":
                plantWater = false;
                break;
        }

        switch(resultHouseClean){
            case "yes" :
                houseClean = true;
                break;
            case "no":
                houseClean = false;
                break;
        }
        List<Housing> listHousing = housingDAO.selectHousingsByConstraints(petKeep,plantWater,houseClean);
        request.setAttribute("listHousing", listHousing);
        RequestDispatcher dispatcherHousing = request.getRequestDispatcher("home.jsp");
        dispatcherHousing.forward(request, response);
    }

}

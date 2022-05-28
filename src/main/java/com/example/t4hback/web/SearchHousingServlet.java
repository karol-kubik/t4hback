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
import java.util.List;

@WebServlet(name = "searchHousingServlet", value = "/search_housing")
public class SearchHousingServlet extends javax.servlet.http.HttpServlet {
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
            this.searchHousing(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void searchHousing(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String keyword = request.getParameter("keyword");
        String city = request.getParameter("city");

        System.out.println("Keyword = " + keyword);

        if(keyword != null){
            List<Housing> listHousing = housingDAO.selectHousingsByTitle(keyword);
            request.setAttribute("listHousing", listHousing);
            RequestDispatcher dispatcherHousing = request.getRequestDispatcher("home.jsp");
            dispatcherHousing.forward(request, response);
        }
        else if(city != null){
            List<Housing> listHousing = housingDAO.selectHousingsByCity(city);
            request.setAttribute("listHousing", listHousing);
            RequestDispatcher dispatcherHousing = request.getRequestDispatcher("home.jsp");
            dispatcherHousing.forward(request, response);
        }
    }

}

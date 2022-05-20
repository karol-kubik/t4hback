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
        Integer id_owner = uid;
        List<Housing> listHousing = housingDAO.selectHousingsByUID(id_owner);
        request.setAttribute("listHousing", listHousing);
        RequestDispatcher dispatcherHousing = request.getRequestDispatcher("userHousings.jsp");
        dispatcherHousing.forward(request, response);
    }

    private void listHousingByOwnerID(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession s = request.getSession(true);
        Integer id = (Integer) s.getAttribute("id");
        List<Housing> listHousing = housingDAO.selectHousingsByID(id);
        request.setAttribute("listHousing", listHousing);
        RequestDispatcher dispatcherHousing = request.getRequestDispatcher("user-housing-list.jsp");
        dispatcherHousing.forward(request, response);
    }

    private void showNewFormHousing(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcherHousing = request.getRequestDispatcher("housing-list.jsp");
        dispatcherHousing.forward(request, response);
    }

    private void showEditFormHousing(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id_housing = Integer.parseInt(request.getParameter("id_housing"));
        Housing existingHousing = housingDAO.selectHousingByHousingID(id_housing);
        RequestDispatcher dispatcherHousing = request.getRequestDispatcher("housing-form.jsp");
        request.setAttribute("housing", existingHousing);
        dispatcherHousing.forward(request, response);

    }

    private void insertHousing(HttpServletRequest request, HttpServletResponse response)
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

    private void updateHousing(HttpServletRequest request, HttpServletResponse response)
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

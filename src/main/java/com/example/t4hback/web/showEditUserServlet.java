package com.example.t4hback.web;

import com.example.t4hback.dao.HousingDAO;
import com.example.t4hback.dao.UserDAO;
import com.example.t4hback.model.Housing;
import com.example.t4hback.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "showEditUserServlet", value = "/edit_user")
public class showEditUserServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            this.showEditFormHousing(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showEditFormHousing(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id_user = Integer.parseInt(request.getParameter("uid"));
        User existingUser = userDAO.selectUser(id_user);
        RequestDispatcher dispatcherHousing = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcherHousing.forward(request, response);

    }

}

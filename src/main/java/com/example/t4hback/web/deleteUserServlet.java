package com.example.t4hback.web;

import com.example.t4hback.dao.UserDAO;
import com.example.t4hback.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "deleteUserServlet", value = "/delete_user")
public class deleteUserServlet extends HttpServlet {
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
            this.deleteUser(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(true);
        Integer uid = (Integer) session.getAttribute("id");
        System.out.println("User to delete = " + uid);
        userDAO.deleteUser(uid);
        session.invalidate();
        RequestDispatcher dispatcherHousing = request.getRequestDispatcher("home");
        dispatcherHousing.forward(request, response);
    }


}

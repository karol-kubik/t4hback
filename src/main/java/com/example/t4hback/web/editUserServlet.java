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

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet(name = "editUserServlet", value = "/update_user")
public class editUserServlet extends HttpServlet {
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
            this.updateUser(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        HttpSession s = request.getSession(true);
        Integer id = (Integer) s.getAttribute("id");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        Integer phone = Integer.valueOf(request.getParameter("phone"));
        Boolean admin = false;

        User book = new User(id, email, password, firstname, lastname, birthday, gender, phone, admin);
        userDAO.updateUser(book);
        response.sendRedirect("user");
    }

}

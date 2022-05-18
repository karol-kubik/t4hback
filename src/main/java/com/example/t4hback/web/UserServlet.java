package com.example.t4hback.web;

import com.example.t4hback.dao.UserDAO;
import com.example.t4hback.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet(name = "userServlet", value = "/user")
public class UserServlet extends HttpServlet {
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
        String action = request.getServletPath();
        System.out.println("Path = " + action);

        try {
            switch (action) {
                case "./new":
                    this.showNewForm(request, response);
                    break;
                case "./insert":
                    this.insertUser(request, response);
                    break;
                case "./delete":
                    this.deleteUser(request, response);
                    break;
                case "./edit":
                    this.showEditForm(request, response);
                    break;
                case "./update":
                    this.updateUser(request, response);
                    break;
                default:
                    this.loginUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String birthday = request.getParameter("birthday");
        Boolean gender = Boolean.valueOf(request.getParameter("gender"));
        Integer phone = Integer.valueOf(request.getParameter("phone"));
        Boolean admin = false;
        User newUser = new User(email, password, firstname, lastname, birthday, gender, phone, admin);
        userDAO.insertUser(newUser);
        response.sendRedirect("list");
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
        Boolean gender = Boolean.valueOf(request.getParameter("gender"));
        Integer phone = Integer.valueOf(request.getParameter("phone"));
        Boolean admin = false;

        User book = new User(id, email, password, firstname, lastname, birthday, gender, phone, admin);
        userDAO.updateUser(book);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        HttpSession s = request.getSession(true);
        Integer id = (Integer) s.getAttribute("id");
        userDAO.deleteUser(id);
        response.sendRedirect("list");

    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession(true);
        if(s.isNew()){
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("account");
            dispatcher.forward(request, response);
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User resultUser = userDAO.selectUserByMailPassword(email, password);

        if(resultUser != null){
            System.out.println("User found.");
            System.out.println("User ID = " + resultUser.getId());
            HttpSession session = request.getSession(false);
            session.setAttribute("email", resultUser.getEmail());
            session.setAttribute("password", resultUser.getPassword());
            session.setAttribute("id", new Integer(resultUser.getId()));
            session.setAttribute("admin", new Boolean(resultUser.getAdmin()));
            RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
            dispatcher.forward(request, response);
        }
        else {
            System.out.println("Wrong credentials.");
            response.sendRedirect("login");
        }
    }

}

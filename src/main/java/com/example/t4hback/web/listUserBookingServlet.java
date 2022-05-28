package com.example.t4hback.web;

import com.example.t4hback.dao.HousingDAO;
import com.example.t4hback.dao.RentDao;
import com.example.t4hback.dao.UserDAO;
import com.example.t4hback.model.Housing;
import com.example.t4hback.model.Rent;
import com.example.t4hback.model.RentFull;
import com.example.t4hback.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listUserBookingsServlet", value = "/my_bookings")
public class listUserBookingServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private HousingDAO housingDAO;
    private RentDao rentDAO;
    private UserDAO userDAO;

    public void init() {
        housingDAO = new HousingDAO();
        rentDAO = new RentDao();
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            this.listRentsByUID(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listRentsByUID(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        Integer uid = (Integer) session.getAttribute("id");
        List<RentFull> listOwnerRentsFull = new ArrayList<>();
        List<RentFull> listGuestRentsFull = new ArrayList<>();
        List<Rent> listOwnerRents = rentDAO.selectRentsByOwner(uid);
        for(Rent rent : listOwnerRents){
            System.out.println("Entering the for 1");
            Housing housing = housingDAO.selectHousingByHousingID(rent.getId_housing());
            User guest = userDAO.selectUser(rent.getId_guest());
            String guestFirstname = guest.getFirstname();
            String guestLastname = guest.getLastname();
            Integer guestPhone = guest.getPhone();
            String housingTitle = housing.getTitle();
            RentFull rentfull = new RentFull(guestFirstname,guestLastname,guestPhone,housingTitle,rent.getId_rent(),rent.getId_guest(),rent.getId_owner(), rent.getId_housing(), rent.getStartDate(),rent.getEndDate(),rent.getState(),rent.getEval(), rent.getComment());
            listOwnerRentsFull.add(rentfull);
        }
        request.setAttribute("listOwnerRentsFull", listOwnerRentsFull);
        List<Rent> listGuestRents = rentDAO.selectRentsByGuest(uid);
        for(Rent rent : listGuestRents){
            System.out.println("Entering the for 2");
            Housing housing = housingDAO.selectHousingByHousingID(rent.getId_housing());
            User owner = userDAO.selectUser(rent.getId_owner());
            String ownerFirstname = owner.getFirstname();
            String ownerLastname = owner.getLastname();
            Integer ownerPhone = owner.getPhone();
            String housingTitle = housing.getTitle();
            String housingCity = housing.getCity();
            String housingAddress = housing.getAddress();
            RentFull rentfull = new RentFull(ownerFirstname,ownerLastname,ownerPhone,housingTitle, housingCity, housingAddress,rent.getId_rent(),rent.getId_guest(),rent.getId_owner(), rent.getId_housing(), rent.getStartDate(),rent.getEndDate(),rent.getState(),rent.getEval(), rent.getComment());
            listGuestRentsFull.add(rentfull);
        }
        request.setAttribute("listGuestRentsFull", listGuestRentsFull);
        RequestDispatcher dispatcherHousing = request.getRequestDispatcher("userBookings.jsp");
        dispatcherHousing.forward(request, response);
    }

}

package com.example.t4hback.dao;

import com.example.t4hback.model.Rent;
import com.example.t4hback.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentDao {

    private String jdbcURL = "jdbc:mysql://localhost:3306/db_t4h?useSSL=FALSE&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_RENT_SQL = "INSERT INTO rents (id_guest, id_owner, id_housing, startDate, endDate, state, eval, comment) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_RENT_BY_RENT_ID = "select id_rent, id_guest, id_owner, id_housing, startDate, endDate, state, eval, comment from rents where id_rent =?";
    private static final String SELECT_RENT_BY_OWNER_ID = "select id_rent, id_guest, id_owner, id_housing, startDate, endDate, state, eval, comment from rents where id_owner =?";
    private static final String SELECT_RENT_BY_GUEST_ID = "select id_rent, id_guest, id_owner, id_housing, startDate, endDate, state, eval, comment from rents where id_guest =?";
    private static final String DELETE_RENT_SQL = "delete from rent where id_rent = ?;";
    private static final String UPDATE_RENT_STATE_SQL = "update rent set state =? where id_rent = ?;";

    public RentDao() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertRent(Rent rent) throws SQLException {
        System.out.println(INSERT_RENT_SQL);
        // try-with-resource statement will auto close the connection.
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RENT_SQL);
            preparedStatement.setInt(1, rent.getId_guest());
            preparedStatement.setInt(2, rent.getId_owner());
            preparedStatement.setInt(3, rent.getId_housing());
            preparedStatement.setDate(4, (Date) rent.getStartDate());
            preparedStatement.setDate(5, (Date) rent.getEndDate());
            preparedStatement.setString(6, rent.getState());
            preparedStatement.setInt(7, rent.getEval());
            preparedStatement.setString(8, rent.getComment());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
    }

    public List<Rent> selectRentsByOwner() throws SQLException {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Rent> rents = new ArrayList<>();
        // Step 1: Establishing a Connection
        Connection connection = getConnection();

        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RENT_BY_OWNER_ID);
        System.out.println(preparedStatement);
        // Step 3: Execute the query or update query
        ResultSet rs = preparedStatement.executeQuery();

        // Step 4: Process the ResultSet object.
        while (rs.next()) {
            int id_rent = rs.getInt("id_rent");
            int id_guest = rs.getInt("id_guest");
            int id_owner = rs.getInt("id_owner");
            int id_housing = rs.getInt("id_housing");
            Date startDate = rs.getDate("startDate");
            Date endDate = rs.getDate("endDate");
            String state = rs.getString("state");
            Integer eval = rs.getInt("eval");
            String comment = rs.getString("comment");
            rents.add(new Rent(id_rent, id_guest, id_owner, id_housing, startDate, endDate, state, eval, comment));
        }
        return rents;
    }

    public List<Rent> selectRentsByID() throws SQLException {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Rent> rents = new ArrayList<>();
        // Step 1: Establishing a Connection
        Connection connection = getConnection();
        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RENT_BY_RENT_ID);
        System.out.println(preparedStatement);
        // Step 3: Execute the query or update query
        ResultSet rs = preparedStatement.executeQuery();

        // Step 4: Process the ResultSet object.
        while (rs.next()) {
            int id_rent = rs.getInt("id_rent");
            int id_guest = rs.getInt("id_guest");
            int id_owner = rs.getInt("id_owner");
            int id_housing = rs.getInt("id_housing");
            Date startDate = rs.getDate("startDate");
            Date endDate = rs.getDate("endDate");
            String state = rs.getString("state");
            Integer eval = rs.getInt("eval");
            String comment = rs.getString("comment");
            rents.add(new Rent(id_rent, id_guest, id_owner, id_housing, startDate, endDate, state, eval, comment));
        }
        return rents;
    }

    public List<Rent> selectRentsByGuest() throws SQLException {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Rent> rents = new ArrayList<>();
        // Step 1: Establishing a Connection
        Connection connection = getConnection();

        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RENT_BY_GUEST_ID);
        System.out.println(preparedStatement);
        // Step 3: Execute the query or update query
        ResultSet rs = preparedStatement.executeQuery();

        // Step 4: Process the ResultSet object.
        while (rs.next()) {
            int id_rent = rs.getInt("id_rent");
            int id_guest = rs.getInt("id_guest");
            int id_owner = rs.getInt("id_owner");
            int id_housing = rs.getInt("id_housing");
            Date startDate = rs.getDate("startDate");
            Date endDate = rs.getDate("endDate");
            String state = rs.getString("state");
            Integer eval = rs.getInt("eval");
            String comment = rs.getString("comment");
            rents.add(new Rent(id_rent, id_guest, id_owner, id_housing, startDate, endDate, state, eval, comment));
        }
        return rents;
    }

    public boolean deleteRent(int id_rent) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_RENT_SQL);) {
            statement.setInt(1, id_rent);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateRentState(Rent rent) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RENT_STATE_SQL);) {
            preparedStatement.setString(1, rent.getState());
            preparedStatement.setInt(2, rent.getId_rent());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

}

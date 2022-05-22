package com.example.t4hback.dao;

import com.example.t4hback.model.Housing;
import com.example.t4hback.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HousingDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/db_t4h?useSSL=FALSE&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_HOUSINGS_SQL = "INSERT INTO housings (id_owner, title, address, city, description, noSmoke, noiseCurfew, noChild, noPets, petKeep, plantWater, houseClean) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?);";
    private static final String SELECT_HOUSINGS_BY_ID = "SELECT id_housing, id_owner, title, address, city, description, noSmoke, noiseCurfew, noChild, noPets, petKeep, plantWater, houseClean from housings where id_housing =?";
    private static final String SELECT_HOUSINGS_BY_UID = "SELECT * FROM housings WHERE id_owner =?";
    private static final String SELECT_ALL_HOUSINGS = "select * from housings";
    private static final String DELETE_HOUSING_SQL = "delete from housings where id_housing = ?;";
    private static final String UPDATE_HOUSING_SQL = "UPDATE housings SET id_owner = ?,title= ?, address =?, city = ?,description= ?, noSmoke =?, noiseCurfew = ?,noChild= ?, noPets =?, petKeep = ?,plantWater= ?, houseClean =? where id_housing = ?;";
    private static final String SELECT_HOUSINGS_BY_CITY = "select id_housing, id_owner, title, address, city, description, noSmoke, noiseCurfew, noChild, noPets, petKeep, plantWater, houseClean from housings where city like ?";
    private static final String SELECT_HOUSINGS_BY_TITLE = "select id_housing, id_owner, title, address, city, description, noSmoke, noiseCurfew, noChild, noPets, petKeep, plantWater, houseClean from housings where title like ?";

    public HousingDAO() {
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

    public void insertHousing(Housing housing) throws SQLException {
        System.out.println(INSERT_HOUSINGS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOUSINGS_SQL)) {
            preparedStatement.setInt(1, housing.getId_owner());
            preparedStatement.setString(2, housing.getTitle());
            preparedStatement.setString(3, housing.getAddress());
            preparedStatement.setString(4, housing.getCity());
            preparedStatement.setString(5, housing.getDescription());
            preparedStatement.setBoolean(6, housing.getNoSmoke());
            preparedStatement.setBoolean(7, housing.getNoiseCurfew());
            preparedStatement.setBoolean(8, housing.getNoChild());
            preparedStatement.setBoolean(9, housing.getNoPets());
            preparedStatement.setBoolean(10, housing.getPetKeep());
            preparedStatement.setBoolean(11, housing.getPlantWater());
            preparedStatement.setBoolean(12, housing.getHouseClean());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public List<Housing> selectHousingsByUID(int uid) {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Housing> housings = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOUSINGS_BY_UID);) {
            preparedStatement.setInt(1,uid);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Integer id_housing = rs.getInt("id_housing");
                Integer id_owner = rs.getInt("id_owner");
                String title = rs.getString("title");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String description = rs.getString("description");
                Boolean noSmoke = rs.getBoolean("noSmoke");
                Boolean noiseCurfew = rs.getBoolean("noiseCurfew");
                Boolean noChild = rs.getBoolean("noChild");
                Boolean noPets = rs.getBoolean("noPets");
                Boolean petKeep = rs.getBoolean("petKeep");
                Boolean plantWater = rs.getBoolean("plantWater");
                Boolean houseClean = rs.getBoolean("houseClean");
                housings.add(new Housing(id_housing,id_owner, title, address, city, description, noSmoke, noiseCurfew, noChild, noPets, petKeep, plantWater, houseClean));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return housings;
    }

    public List<Housing> selectHousingsByID(int id) {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Housing> housings = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOUSINGS_BY_ID);) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Integer id_housing = rs.getInt("id_housing");
                Integer id_owner = rs.getInt("id_owner");
                String title = rs.getString("title");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String description = rs.getString("description");
                Boolean noSmoke = rs.getBoolean("noSmoke");
                Boolean noiseCurfew = rs.getBoolean("noiseCurfew");
                Boolean noChild = rs.getBoolean("noChild");
                Boolean noPets = rs.getBoolean("noPets");
                Boolean petKeep = rs.getBoolean("petKeep");
                Boolean plantWater = rs.getBoolean("plantWater");
                Boolean houseClean = rs.getBoolean("houseClean");
                housings.add(new Housing(id_housing,id_owner, title, address, city, description, noSmoke, noiseCurfew, noChild, noPets, petKeep, plantWater, houseClean));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return housings;
    }

    public List<Housing> selectAllHousings() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Housing> housings = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOUSINGS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Integer id_housing = rs.getInt("id_housing");
                Integer id_owner = rs.getInt("id_owner");
                String title = rs.getString("title");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String description = rs.getString("description");
                Boolean noSmoke = rs.getBoolean("noSmoke");
                Boolean noiseCurfew = rs.getBoolean("noiseCurfew");
                Boolean noChild = rs.getBoolean("noChild");
                Boolean noPets = rs.getBoolean("noPets");
                Boolean petKeep = rs.getBoolean("petKeep");
                Boolean plantWater = rs.getBoolean("plantWater");
                Boolean houseClean = rs.getBoolean("houseClean");
                housings.add(new Housing(id_housing,id_owner, title, address, city, description, noSmoke, noiseCurfew, noChild, noPets, petKeep, plantWater, houseClean));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return housings;
    }

    public Housing selectHousingByHousingID(int id) {
        Housing housing = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOUSINGS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Integer id_housing = rs.getInt("id_housing");
                Integer id_owner = rs.getInt("id_owner");
                String title = rs.getString("title");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String description = rs.getString("description");
                Boolean noSmoke = rs.getBoolean("noSmoke");
                Boolean noiseCurfew = rs.getBoolean("noiseCurfew");
                Boolean noChild = rs.getBoolean("noChild");
                Boolean noPets = rs.getBoolean("noPets");
                Boolean petKeep = rs.getBoolean("petKeep");
                Boolean plantWater = rs.getBoolean("plantWater");
                Boolean houseClean = rs.getBoolean("houseClean");
                housing = new Housing(id_housing,id_owner, title, address, city, description, noSmoke, noiseCurfew, noChild, noPets, petKeep, plantWater, houseClean);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return housing;
    }

    public List<Housing> selectHousingsByCity(String enteredCity) {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Housing> housings = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOUSINGS_BY_CITY);) {
            preparedStatement.setString(1,enteredCity);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Integer id_housing = rs.getInt("id_housing");
                Integer id_owner = rs.getInt("id_owner");
                String title = rs.getString("title");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String description = rs.getString("description");
                Boolean noSmoke = rs.getBoolean("noSmoke");
                Boolean noiseCurfew = rs.getBoolean("noiseCurfew");
                Boolean noChild = rs.getBoolean("noChild");
                Boolean noPets = rs.getBoolean("noPets");
                Boolean petKeep = rs.getBoolean("petKeep");
                Boolean plantWater = rs.getBoolean("plantWater");
                Boolean houseClean = rs.getBoolean("houseClean");
                housings.add(new Housing(id_housing,id_owner, title, address, city, description, noSmoke, noiseCurfew, noChild, noPets, petKeep, plantWater, houseClean));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return housings;
    }

    public List<Housing> selectHousingsByTitle(String enteredTitle) {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Housing> housings = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOUSINGS_BY_TITLE);) {
            preparedStatement.setString(1,enteredTitle);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Integer id_housing = rs.getInt("id_housing");
                Integer id_owner = rs.getInt("id_owner");
                String title = rs.getString("title");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String description = rs.getString("description");
                Boolean noSmoke = rs.getBoolean("noSmoke");
                Boolean noiseCurfew = rs.getBoolean("noiseCurfew");
                Boolean noChild = rs.getBoolean("noChild");
                Boolean noPets = rs.getBoolean("noPets");
                Boolean petKeep = rs.getBoolean("petKeep");
                Boolean plantWater = rs.getBoolean("plantWater");
                Boolean houseClean = rs.getBoolean("houseClean");
                housings.add(new Housing(id_housing,id_owner, title, address, city, description, noSmoke, noiseCurfew, noChild, noPets, petKeep, plantWater, houseClean));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return housings;
    }

    public boolean deleteHousing(int id_housing) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_HOUSING_SQL);) {
            statement.setInt(1, id_housing);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateHousing(Housing housing) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HOUSING_SQL);) {
            preparedStatement.setInt(1, housing.getId_owner());
            preparedStatement.setString(2, housing.getTitle());
            preparedStatement.setString(3, housing.getAddress());
            preparedStatement.setString(4, housing.getCity());
            preparedStatement.setString(5, housing.getDescription());
            preparedStatement.setBoolean(6, housing.getNoSmoke());
            preparedStatement.setBoolean(7, housing.getNoiseCurfew());
            preparedStatement.setBoolean(8, housing.getNoChild());
            preparedStatement.setBoolean(9, housing.getNoPets());
            preparedStatement.setBoolean(10, housing.getPetKeep());
            preparedStatement.setBoolean(11, housing.getPlantWater());
            preparedStatement.setBoolean(12, housing.getHouseClean());
            preparedStatement.setInt(13, housing.getId_housing());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}

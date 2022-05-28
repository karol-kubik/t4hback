package com.example.t4hback.dao;

import com.example.t4hback.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/db_t4h?useSSL=FALSE&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_USERS_SQL = "INSERT INTO users(email, password, firstname, lastname, birthday, gender, phone, admin) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "SELECT * FROM `users` WHERE `id` =?;";
	private static final String SELECT_USER_BY_MAIL_PASSWORD = "SELECT * FROM `users` WHERE `email` = ? AND `password` = ?;";
	private static final String UPDATE_USERS_SQL = "update users set email = ?,password= ?, firstname =?, lastname =?, birthday =?, gender =?, phone =?, admin =? where id = ?;";

	//ADMIN FUNCTIONS
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";

	public UserDAO() {
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

	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFirstname());
			preparedStatement.setString(4, user.getLastname());
			preparedStatement.setDate(5, user.getBirthday());
			preparedStatement.setString(6, user.getGender());
			preparedStatement.setInt(7, user.getPhone());
			preparedStatement.setBoolean(8, false);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public User selectUser(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String email = rs.getString("email");
				String password = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				Date birthday = rs.getDate("birthday");
				String gender = rs.getString("gender");
				Integer phone = rs.getInt("phone");
				Boolean admin = rs.getBoolean("admin");
				user = new User(id,email, password, firstname, lastname, birthday, gender, phone, admin);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public User selectUserByMailPassword(String enteredEmail, String enteredPassword) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
			 // Step 2:Create a statement using connection object
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_MAIL_PASSWORD);) {
			preparedStatement.setString(1, enteredEmail);
			preparedStatement.setString(2, enteredPassword);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				Date birthday = rs.getDate("birthday");
				String gender = rs.getString("gender");
				Integer phone = rs.getInt("phone");
				Boolean admin = rs.getBoolean("admin");
				user = new User(id,email, password, firstname, lastname, birthday, gender, phone, admin);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				Date birthday = rs.getDate("birthday");
				String gender = rs.getString("gender");
				Integer phone = rs.getInt("phone");
				Boolean admin = rs.getBoolean("admin");
				users.add(new User(id, email, password, firstname, lastname, birthday, gender, phone, admin));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFirstname());
			preparedStatement.setString(4, user.getLastname());
			preparedStatement.setDate(5, user.getBirthday());
			preparedStatement.setString(6, user.getGender());
			preparedStatement.setInt(7, user.getPhone());
			preparedStatement.setBoolean(8, user.getAdmin());
			preparedStatement.setInt(9, user.getId());

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

package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import utils.DatabaseConnectivity;
import utils.PasswordHash;

public class UserDao {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private boolean isSucess;
	
	public UserDao() {
		conn = DatabaseConnectivity.getDbConnection();
	}
	
	public int insertUserData(User user) {
		int row=0;
		try {
			statement=conn.prepareStatement("INSERT INTO user_register(Firstname,Lastname,Username,dob,gender,email,phoneNumber,address,password) values(?,?,?,?,?,?,?,?,?)");
		
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getUsername());
			statement.setDate(4, user.getDob());
			statement.setString(5, user.getGender());
			statement.setString(6, user.getEmail());
			statement.setLong(7, user.getPhoneNumber());
			statement.setString(8, user.getAddress());
			statement.setString(9, user.getPassword());
			
			row=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
		}
	
	public boolean userLogin(String username, String password) throws SQLException {
		statement = conn.prepareStatement("select username,password from user_register where username=?");
		statement.setString(1, username);
		resultSet = statement.executeQuery();
		boolean isSuccess = false;
		if (resultSet.next()) {
			String passwordFromDb = resultSet.getString("password");

			if (PasswordHash.checkPassword(passwordFromDb, password)) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		}
		return isSuccess;

	}
	
	public boolean saveUser(User User) {
		try {
			statement = conn.prepareStatement("select count(*) from user_register");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				if (check(User)) {
					isSucess = false;
				} else {
					int row = insertUserData(User);
					if (row > 0) {
						isSucess = true;
					} else {
						isSucess = false;
					}
				}

			} else {
				int row = insertUserData(User);
				if (row > 0) {
					isSucess = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSucess;
	}
	


	public boolean check(User User) {
		boolean isFind = false;
		try {
			statement = conn.prepareStatement("select username,email,phoneNumber from user_register");
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				if (User.getUsername().equals(resultSet.getString("username"))) {
					isFind = true;
					break;
				} else if (User.getEmail().equals(resultSet.getString("email"))) {
					isFind = true;
					break;
				} else if (User.getPhoneNumber() == resultSet.getLong("phoneNumber")) {
					isFind = true;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isFind;
	}
	public List<User> getAllUser() throws SQLException {
		statement=conn.prepareStatement("select * from student_register");
		resultSet=statement.executeQuery();
		List<User> listOfUser=new ArrayList<User>();
		while(resultSet.next())
		{
			int id=resultSet.getInt("id");
			String firstName=resultSet.getString("firstName");
			String lastName=resultSet.getString("lastName");
			String username=resultSet.getString("username");
			Date dob=resultSet.getDate("dob");
			String gender=resultSet.getString("gender");
			String email=resultSet.getString("email");
			long phoneNumber=resultSet.getLong("phoneNumber");
			String address=resultSet.getString("address");
			String password=resultSet.getString("password");
			
			User user=new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setUsername(username);
			user.setDob(dob);
			user.setGender(gender);
			user.setEmail(email);
			user.setPhoneNumber(phoneNumber);
			user.setAddress(address);
			user.setPassword(password);
			
			listOfUser.add(user);
		}
		return listOfUser;
	}

}

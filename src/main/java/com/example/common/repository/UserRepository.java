package com.example.common.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.common.DB.DBConnection;
import com.example.common.model.UserDto;
import com.sun.java_cup.internal.internal_error;

public class UserRepository {

	private Connection connection;

	public UserRepository() {
		try {
			this.connection = DBConnection.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
//////Method for register user data in db
	public int loginUser(String username, String password) throws Exception {
		ResultSet rs = null;
		int i = 0;
		try {
			String sql = "SELECT users.username, users.password FROM users where users.username = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).equalsIgnoreCase(username) && 	rs.getString(2).equalsIgnoreCase(password))
				{
						return 1;
					
				}
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (connection != null) {
				connection.close();

			}
		}
	}

	////// Method for register user data in db
	public int registerUser(UserDto userDto) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO users (username,password,age,address,email) VALUES (?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userDto.getUsername());
			ps.setString(2, userDto.getPassword());
			ps.setInt(3, userDto.getAge());
			ps.setString(4, userDto.getAddress());
			ps.setString(5, userDto.getEmail());
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (connection != null) {
				connection.close();

			}
		}
	}

	////////// Method for list all user from db
	public List<UserDto> getAllUsers() throws SQLException, Exception {
		ResultSet rs = null;
		List<UserDto> list = new ArrayList<UserDto>();
		try {
			String sql = "Select * from users;";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserDto user = new UserDto(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				list.add(user);
			}
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		return list;
	}

	/////////// Method for get User by username from db
	public UserDto getUserbyUsername(String username) throws SQLException, Exception {
		ResultSet rs = null;
		UserDto userDto = null;
		try {
			String sql = "SELECT users.username, users.age, users.email, users.address, users.password FROM users where users.username = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				userDto = new UserDto(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			return userDto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	////////// Method for delete a user in db
	public int deleteUser(String username) throws SQLException {
		int i = 0;
		try {
			String sql = "Delete from users where username=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			i = ps.executeUpdate();
			System.out.println("Delete username = \"" + username + "\" successfully.");
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

//////Method for update info of user in db
	public int updateUser(UserDto userDto) throws Exception {
		int i = 0;
		try {
			String sql = "UPDATE users SET username=?,password=?,age=?,address=?,email=? WHERE username=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userDto.getUsername());
			ps.setString(2, userDto.getPassword());
			ps.setInt(3, userDto.getAge());
			ps.setString(4, userDto.getAddress());
			ps.setString(5, userDto.getEmail());
			ps.setString(6, userDto.getUsername());
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (connection != null) {
				connection.close();

			}
		}
	}

}

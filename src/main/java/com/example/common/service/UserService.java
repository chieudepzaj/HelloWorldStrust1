package com.example.common.service;

import java.sql.SQLException;
import java.util.List;

import com.example.common.model.UserDto;
import com.example.common.repository.UserRepository;

public class UserService {

	private UserRepository userRepository;

	public UserService() {
		userRepository = new UserRepository();
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public int addUser(UserDto userDto) {
		try {
			return userRepository.registerUser(userDto);
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}

	public int deleteUser(String username) {
		try {
			return userRepository.deleteUser(username);
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public int login(String username, String password) {
		try {
			return userRepository.loginUser(username,password);
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}

	public int updateUser(UserDto userDto) {
		try {
			return userRepository.updateUser(userDto);
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}

	public UserDto getUserByUsername(String username) throws SQLException, Exception {
		return userRepository.getUserbyUsername(username);
	}

	public List<UserDto> getListUsers() throws SQLException, Exception {
		return userRepository.getAllUsers();
	}

}

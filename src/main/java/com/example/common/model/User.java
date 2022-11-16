package com.example.common.model;

import org.apache.struts.action.ActionForm;

public class User extends ActionForm {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private String username;
	private int age;
	private String email;
	private String address;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

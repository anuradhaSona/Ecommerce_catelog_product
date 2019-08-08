package com.ecom.app.dto;
import java.io.Serializable;

import javax.validation.constraints.Email;

import org.springframework.data.annotation.Transient;

public class UserDto implements Serializable {

	private static final long serialVersionID = 1L;

	private String name;

	private String email;

	private String password;

	private String confirmPassword;

	private int age;

	public int getAge() {

		return age;

	}

	public String getConfirmPassword() {

		return confirmPassword;

	}

	public String getEmail() {

		return email;

	}

	public String getName() {

		return name;

	}

	public String getPassword() {

		return password;

	}

	public void setAge(int age) {

		this.age = age;

	}

	public void setConfirmPassword(String confirmPassword) {

		this.confirmPassword = confirmPassword;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public void setName(String name) {

		this.name = name;

	}

	public void setPassword(String password) {

		this.password = password;

	}

}

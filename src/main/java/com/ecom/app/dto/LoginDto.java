package com.ecom.app.dto;

import java.io.Serializable;

public class LoginDto implements Serializable {

	private static final long serialVersionId = 1L;

	private String name;

	private String password;

	public String getName() {

		return name;

	}

	public String getPassword() {

		return password;

	}

	public void setName(String name) {

		this.name = name;

	}

	public void setPassword(String password) {

		this.password = password;

	}
}

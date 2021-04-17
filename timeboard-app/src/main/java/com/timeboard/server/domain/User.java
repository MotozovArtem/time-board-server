package com.timeboard.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * todo motozov.
 */
@Entity(name = "User")
@Table(name = User.TABLE_NAME)
public class User extends DomainEntity {

	/**
	 * todo motozov.
	 */
	public static final String TABLE_NAME = "timeboard_user";

	/**
	 * todo motozov.
	 */
	public static class ColumnName {

		/**
		 * todo motozov.
		 */
		public static final String U_CN_LOGIN = "login";

		/**
		 * todo motozov.
		 */
		public static final String U_CN_PASSWORD = "password";

		/**
		 * todo motozov.
		 */
		public static final String U_CN_EMAIL = "email";

		/**
		 * todo motozov.
		 */
		public static final String U_CN_FIRST_NAME = "first_name";

		/**
		 * todo motozov.
		 */
		public static final String U_CN_SECOND_NAME = "second_name";

		/**
		 * todo motozov.
		 */
		public static final String U_CN_ICON_URL = "icon_url";
	}

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.U_CN_LOGIN, unique = true, nullable = false)
	private String login;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.U_CN_PASSWORD, nullable = false)
	private String password;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.U_CN_EMAIL, unique = true, nullable = false)
	private String email;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.U_CN_FIRST_NAME, nullable = false)
	private String firstName;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.U_CN_SECOND_NAME, nullable = false)
	private String secondName;

	/**
	 * todo motozov.
	 */
	@Column(name = ColumnName.U_CN_ICON_URL)
	private String iconUrl;

	/**
	 * Constructor.
	 */
	public User() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
}

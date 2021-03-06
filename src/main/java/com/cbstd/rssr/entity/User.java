package com.cbstd.rssr.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.cbstd.rssr.annotation.UniqueUsername;

@Entity
@Table(name = "rssr_user", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) })
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 5, max = 32, message = "{com.cbstd.rssr.entity.User.username.size}")
	@Column(unique = true)
	@UniqueUsername(message = "{com.cbstd.rssr.entity.User.username.exists}")
	private String username;

	@Size(min = 1, message = "{com.cbstd.rssr.entity.User.email.email}")
	@Email(message = "{com.cbstd.rssr.entity.User.email.email}")
	private String email;

	@Size(min = 5, max = 256, message = "{com.cbstd.rssr.entity.User.password.size}")
	private String password;

	@ManyToMany
	private List<Role> roles;

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Feed> feeds;

	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Feed> getFeeds() {
		return feeds;
	}

	public void setFeeds(List<Feed> feeds) {
		this.feeds = feeds;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

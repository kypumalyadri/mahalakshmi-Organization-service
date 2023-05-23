package com.organisation.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "UserLogin")
@Data
@ToString

public class UserLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "USER_NAME", nullable = false, length = 250)
	@NotNull(message = "username connot be null")
	private String userName;
	@Column(name = "PASSWORD", nullable = false, length = 250)
	@NotNull(message = "password connot be null")
	private String password;
	@Column(name = "EMAIL",nullable = false)
	@NotNull(message = "email can not null")
	private String email;

}

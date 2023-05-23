package com.organisation.service.Service;

import java.util.List;
import java.util.Optional;

import com.organisation.service.entity.UserLogin;

import jakarta.validation.Valid;

public interface UserLoginService {
	UserLogin createUserLogin(UserLogin userLogin);

	Optional<UserLogin> getUserLoginById(Long id);

	UserLogin updateUserLogin(UserLogin userLogin);

	List<UserLogin> getAllUserLogins();

	UserLogin deletebyUserLogin(@Valid Long id);

}

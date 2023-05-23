package com.organisation.service.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organisation.service.Repository.UserLoginRepository;
import com.organisation.service.Service.UserLoginService;
import com.organisation.service.entity.UserLogin;

import jakarta.validation.Valid;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginRepository userLoginRepository;

	@Override
	public UserLogin createUserLogin(UserLogin userLogin) {
		return userLoginRepository.save(userLogin);
	}

	@Override
	public Optional<UserLogin> getUserLoginById(Long id) {
	    Optional<UserLogin> userLoginOptional = userLoginRepository.findById(id);
	    if (userLoginOptional.isPresent()) {
	        return userLoginOptional;
	    } else {
	        
	        throw new IllegalArgumentException("User login not found for ID: " + id);
	    }
	}

	@Override
	public UserLogin updateUserLogin(UserLogin userLogin) {
	    UserLogin updatedUserLogin = userLoginRepository.save(userLogin);
	    if (updatedUserLogin != null) {
	        return updatedUserLogin;
	    } else {
	        
	        throw new RuntimeException("Failed to update user login");
	    }
	}

@Override
public List<UserLogin> getAllUserLogins() {
    List<UserLogin> userLogins = userLoginRepository.findAll();
    if (!userLogins.isEmpty()) {
        return userLogins;
    } else {
       
        throw new RuntimeException("No user logins found");
    }
}

@Override
	public UserLogin deletebyUserLogin(@Valid Long id) {
		Optional<UserLogin> userLoginOptional = userLoginRepository.findById(id);
		if (userLoginOptional.isPresent()) {
			UserLogin userLogin = userLoginOptional.get();
			userLoginRepository.delete(userLogin);
			return userLogin;
		} else {
			throw new IllegalArgumentException("User login with ID " + id + " does not exist.");
		}
	}

}

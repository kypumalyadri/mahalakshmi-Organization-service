package com.organisation.service.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organisation.service.Service.UserLoginService;
import com.organisation.service.entity.UserLogin;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/userLogin")

public class UserLoginController {
	private static final String CORS_ORIGIN = "*";
	@Autowired
	private UserLoginService userLoginService;

	@PostMapping(value = "/save")
	@CrossOrigin(origins = CORS_ORIGIN)
	public ResponseEntity<UserLogin> createUserLogin(@RequestBody UserLogin userLogin) {
		UserLogin createdUserLogin = userLoginService.createUserLogin(userLogin);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUserLogin);
	}

	@GetMapping(value = "/{Id}")
	@CrossOrigin(origins = CORS_ORIGIN)
	public ResponseEntity<Optional<UserLogin>> getUserLoginById(@PathVariable Long id) {
		Optional<UserLogin> userLogin = userLoginService.getUserLoginById(id);
		if (userLogin != null) {
			return ResponseEntity.ok(userLogin);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(value = "/{all}")
	@CrossOrigin(origins = CORS_ORIGIN)
	public ResponseEntity<List<UserLogin>> getAllUserLogins() {
		List<UserLogin> userLogin = userLoginService.getAllUserLogins();
		if (userLogin != null) {
			return ResponseEntity.ok(userLogin);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserLogin> updateUserLogin(@PathVariable Long id, @RequestBody UserLogin userLogin) {
		Optional<UserLogin> existingUserLogin = userLoginService.getUserLoginById(id);
		if (existingUserLogin != null) {
			userLogin.setId(id);
			UserLogin updatedUserLogin = userLoginService.updateUserLogin(userLogin);
			return ResponseEntity.ok(updatedUserLogin);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(value = "/{Id}")
	@CrossOrigin(origins = CORS_ORIGIN)
	public ResponseEntity<UserLogin> deletebyUserLogin(@Valid Long id) {
		UserLogin userLogin = userLoginService.deletebyUserLogin(id);
		if (userLogin != null) {
			userLoginService.deletebyUserLogin(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
}

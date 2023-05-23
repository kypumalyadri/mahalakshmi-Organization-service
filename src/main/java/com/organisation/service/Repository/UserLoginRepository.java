package com.organisation.service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organisation.service.entity.UserLogin;

@Repository

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {

}

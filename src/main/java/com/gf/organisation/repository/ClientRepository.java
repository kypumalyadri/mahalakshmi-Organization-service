package com.gf.organisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gf.organisation.entity.Client;

@Repository

public interface ClientRepository extends JpaRepository<Client, Long> {

}

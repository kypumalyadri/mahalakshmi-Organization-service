package com.gf.organisation.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @NotNull(message = "id cannot be null")
    private Long id;
    
    @Column(name = "CLIENT_NAME")
    @NotNull(message = "name cannot be null")
    private String name;
    
    
    @Column(name = "CLIENT_CODE")
    @NotNull(message = "client code cannot be null")
    private String clientCode;
    
    @Column(name = "STATUS")
    @NotNull(message = "Status cannot be null")
    private Boolean status;
    
    @Column(name = "DOJ")
    @NotNull(message = "DOJ cannot be null")
    private LocalDate doj;
    
    @Column(name = "EXECUTIVE_TITLE")
    @NotNull(message = "Executive Title cannot be null")
    private String executiveTitle;
    
    @Column(name = "EXECUTIVE_NAME")
    @NotNull(message = "Executive Name cannot be null")
    private String executiveName;
    
    @Column(name = "CONTACT_EMAIL")
    @NotNull(message = "Contact Email cannot be null")
    private String contactEmail;
    
    @Column(name = "CONTACT_NUMBER")
    @NotNull(message = "Contact number cannot be null")
    private String contactNumber;
    
    
}


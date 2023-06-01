package com.gf.organisation.entity;



import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "Project")
@ToString
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    @Column(name = "PROJECT_STATUS") 
    @NotNull(message = "Project status cannot be null")
    private Boolean projectStatus;


    @Column(name = "PROJECT_CODE")
    @NotNull(message = "Project code cannot be null")
    private String projectCode;

    @Column(name = "PROJECT_NAME")
    @NotNull(message = "Project name cannot be null")
    private String projectName;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    @NotNull(message = "Client cannot be null")
    private Client client;

}


package com.gf.organisation.entity;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "Departments")
@ToString
@EqualsAndHashCode
@Data
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DEPARTMENT_NAME", nullable = false)
    @NotNull(message = "Department name cannot be null")
    private String departmentName;

    @Column(name = "DEPARTMENT_CODE", nullable = false)
    @NotNull(message = "Department code cannot be null")
    private String departmentCode;

    @Column(name = "DEPARTMENT_HEAD", nullable = false)
    @NotNull(message = "Department head cannot be null")
    private String departmentHead;

    @Column(name = "STARTED_ON", nullable = false)
    @NotNull(message = "Started on date cannot be null")
    private LocalDateTime startedOn;

    @Column(name = "TIME_ZONE", nullable = false)
    @NotNull(message = "Time zone cannot be null")
    private LocalDateTime timeZone;

    @Column(name = "DESCRIPTION", nullable = false)
    @NotNull(message = "Description cannot be null")
    private String description;

    @Column(name = "COUNTRY", nullable = false)
    @NotNull(message = "Country cannot be null")
    private String country;

    @Column(name = "STATE", nullable = false)
    @NotNull(message = "State cannot be null")
    private String state;

    @Column(name = "CITY", nullable = false)
    @NotNull(message = "City cannot be null")
    private String city;

    @Column(name = "STREET_ADDRESS", nullable = false)
    @NotNull(message = "Street address cannot be null")
    private String streetAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BUSINESS_UNITS")
    private Business business;

}

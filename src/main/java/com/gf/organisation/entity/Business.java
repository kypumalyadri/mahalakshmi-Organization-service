package com.gf.organisation.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "BusinessUnits")
@ToString
@EqualsAndHashCode
@Data
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    @NotNull(message = "name can not be null")
    private String name;

    @Column(name = "CODE", nullable = false)
    @NotNull(message = "code can not be null")
    private String code;

    @Column(name = "DESCRIPTION", nullable = false)
    @NotNull(message = "description can not be null")
    private String description;

    @Column(name = "TIME_ZONE", nullable = false)
    @NotNull(message = "Time zone cannot be null")
    private LocalDateTime timeZone;

    @Column(name = "COUNTRY", nullable = false)
    @NotNull(message = "country can not be null")
    private String country;

    @Column(name = "STARTED", nullable = false)
    private LocalDateTime started;

    @Column(name = "STATE", nullable = false)
    @NotNull(message = "state can not be null")
    private String state;

    @Column(name = "CITY", nullable = false)
    @NotNull(message = "city can not be null")
    private String city;

    @Column(name = "STREET_ADDRESS", nullable = false)
    @NotNull(message = "street can not be null")
    private String streetAddress;
    
   // @OneToMany(mappedBy = "businessUnit", cascade = CascadeType.ALL)
   // private List<Departments> departments;
}

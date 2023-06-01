package com.gf.organisation.entity;

import javax.validation.Valid;
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
import lombok.ToString;

@Entity
@Table(name = "Announcements")
@Data
@ToString
public class Announcements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "BUSINESS_UNITS")
    @NotNull(message = "Business must be provided")
    private Business business;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENTS")
    @NotNull(message = "Department must be provided")
    private Departments departments;

    @Column(name = "TITLE", nullable = false)
    @NotNull(message = "Title must be provided")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;
}

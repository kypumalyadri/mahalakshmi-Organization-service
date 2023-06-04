package com.gf.organisation.entity;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.bytebuddy.asm.Advice.Local;

@Entity
@Table(name = "OrganisationInfo")
@Data
@ToString
@EqualsAndHashCode
public class OrganisationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "ORGANISATION_NAME", nullable = false, length = 250)
    @NotNull(message = "organisation name cannot be null")
    private String organisationName;

    @Column(name = "ORGANISATION_DESCRIPTION", nullable = false, length = 250)
    @NotNull(message = " organisation desription cannot be null")
    private String organisationDescription;

    @Column(name = "BUSINESS_DOMAIN", nullable = false)
    @NotNull(message = "business domain cannot be null")
    private String businessDomain;

    @Column(name = "WEBSITE", nullable = false)
    @NotNull(message = "Website cannot be null")
    private String website;

    @Column(name = "STARTED_ON", nullable = false, length = 250)
    @NotNull(message = "Started on cannot be null")
    private LocalDateTime startedOn;

    @Column(name = "PRIMARY_PHONE", nullable = false, length = 250)
    @NotNull(message = "Primary phone cannot be null")
    private Long primaryPhone;

    @Column(name = "COUNTRY", nullable = false, length = 400)
    @NotNull(message = "Country cannot be null")
    private String country;

    @Column(name = "CITY", nullable = false)
    @NotNull(message = "city cannot be null")
    private String city;
    
    @Column(name = "ADDRESS1", nullable = false)
    @NotNull(message = "Address1 cannot be null")
    private String address1;
    
    @Column(name = "ADDRESS2", nullable = false)
    @NotNull(message = "Address cannot be null")
    private String address;
    
    @Column(name = "SECONDARY_PHONE", nullable = false)
    @NotNull(message = "Secondary phone cannot be null")
    private String secondaryPhone;
    
    @Column(name = "STATE", nullable = false)
    @NotNull(message = "State cannot be null")
    private String state;
    
    @Column(name = "MAINBRANCH_ADDRESS", nullable = false)
    @NotNull(message = "MainbranchAddress cannot be null")
    private String MainbranchAddresss;
}

package com.gf.organisation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "Organisation")
@Data
@ToString
@EqualsAndHashCode
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "COMPANY_NAME", nullable = false, length = 250)
    @NotNull(message = "Company name cannot be null")
    private String companyName;

    @Column(name = "MAINBRANCH_LOCATION", nullable = false, length = 250)
    @NotNull(message = "Main branch location cannot be null")
    private String mainBranchLocation;

    @Column(name = "MULTIPLE_LOCATION", nullable = false)
    @NotNull(message = "Multiple location cannot be null")
    private Boolean multipleLocation;

    @Column(name = "OTHER_LOCATION", nullable = false)
    @NotNull(message = "Other location cannot be null")
    private Boolean otherLocation;

    @Column(name = "EMPLOYEES", nullable = false, length = 250)
    @NotNull(message = "Employees cannot be null")
    private String employees;

    @Column(name = "GST_NO", nullable = false, length = 250)
    @NotNull(message = "GST number cannot be null")
    private String gstNo;

    @Column(name = "CLIENT", nullable = false, length = 400)
    @NotNull(message = "Client cannot be null")
    private String client;

    @Column(name = "PROJECT", nullable = false)
    @NotNull(message = "Project cannot be null")
    private String project;
}

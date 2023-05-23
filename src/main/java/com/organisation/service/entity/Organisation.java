package com.organisation.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "Organisation")
@Data
@ToString

public class Organisation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "COMPANY_NAME", nullable = false, length = 250)
	@NotNull(message = "companyname connot be null")
	private String companyName;
	@Column(name = "MAINBRANCH_LOCATION", nullable = false, length = 250)
	@NotNull(message = "mainbranchLacotion connot be null")
	private String mainbranchLocation;
	@Column(name = "MULTIBLE_LOCATION", nullable = false, length = 250)
	@NotNull(message = "multiblelocation cannot be null")
	private boolean multibleLocation;
	@Column(name = "OTHER_LOCATION")
	private boolean otherLocation;
	@Column(name = "EMPLOYEES", nullable = false, length = 250)
	@NotNull(message = "employees cannot be null")
	private String employees;
	@Column(name = "GST_NO", nullable = false, length = 250)
	@NotNull(message = "gstNo cannot be null")
	private String gstNo;
	@Column(name = "CLIENT", nullable = false, length = 400)
	@NotNull(message = "client cannot be null")
	private String client;
	@Column(name = "PROJECT", nullable = false)
	@NotNull(message = "project cannot be null")
	private String project;

}

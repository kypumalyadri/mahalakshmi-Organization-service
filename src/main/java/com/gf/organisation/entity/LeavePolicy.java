package com.gf.organisation.entity;

import java.util.List;

import javax.validation.constraints.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "LeavePolicy")
@Data
@ToString
public class LeavePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DOCUMENT_NAME", nullable = false)
    @NotNull(message = "Document name cannot be null")
    private String documentName;

    @Column(name = "VERSION", nullable = false)
    @NotNull(message = "Version cannot be null")
    private String version;

    @Column(name = "CATEGORY", nullable = false, unique = true) // Ensure the column is unique
    @NotNull(message = "Category cannot be null")
    private String category;

    @Column(name = "DESCRIPTION", nullable = false)
    @NotNull(message = "Description cannot be null")
    private String description;

    @Column(name = "UPLOAD_DOCUMENT", nullable = false)
    @NotNull(message = "Upload document cannot be null")
    private String uploadDocument;

}



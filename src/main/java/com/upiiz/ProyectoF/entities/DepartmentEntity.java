package com.upiiz.ProyectoF.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "department_name", nullable = false, length = 100)
    private String departmentName;

    @Column(name = "usr")
    private String user;

//    @Version
//    @Column(name = "version")
//    private Integer version;

//    @Column(name = "created_at", nullable = false, updatable = false)
//    private java.time.LocalDateTime createdAt;
//
//    @Column(name = "updated_at")
//    private java.time.LocalDateTime updatedAt;
//
//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = java.time.LocalDateTime.now();
//    }

//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = java.time.LocalDateTime.now();
//    }


}

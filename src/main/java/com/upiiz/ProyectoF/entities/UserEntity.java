package com.upiiz.ProyectoF.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // Ejemplo: "USER" o "ADMIN"


    public boolean isPresent() {
        return false;
    }
}

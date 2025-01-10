package com.upiiz.ProyectoF.controllers;

import com.upiiz.ProyectoF.entities.UserEntity;
import com.upiiz.ProyectoF.repositories.UserRepository;
import com.upiiz.ProyectoF.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody UserEntity user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "El usuario ya existe";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encripta contraseña
        userRepository.save(user);
        return "Usuario registrado exitosamente";
    }
}

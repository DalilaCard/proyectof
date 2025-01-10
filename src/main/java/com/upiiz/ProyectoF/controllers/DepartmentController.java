package com.upiiz.ProyectoF.controllers;

import com.upiiz.ProyectoF.entities.DepartmentEntity;
import com.upiiz.ProyectoF.services.DepartmentService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping
    @PreAuthorize("hasAuthority('READ')")
    public List<DepartmentEntity> getAllDepartments(Authentication authentication) {
        String userId = authentication.name(); // Usuario autenticado
        return service.getAllDepartments(userId);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<DepartmentEntity> getDepartmentById(@PathVariable Integer id) {
        DepartmentEntity department = service.getDepartmentById(id);
        return (department != null) ? ResponseEntity.ok(department) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<DepartmentEntity> createDepartment(@RequestBody DepartmentEntity department, Authentication authentication) {
        String userId = authentication.name(); // Asignar el usuario autenticado al departamento
        department.setUserId(userId);
        return ResponseEntity.ok(service.createDepartment(department));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public ResponseEntity<DepartmentEntity> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentEntity department) {
        DepartmentEntity updatedDepartment = service.updateDepartment(id, department);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE')")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Integer id) {
        service.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}

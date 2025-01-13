package com.upiiz.ProyectoF.controllers;

import com.upiiz.ProyectoF.entities.DepartmentEntity;
import com.upiiz.ProyectoF.services.DepartmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

import java.util.List;
@RestController
@RequestMapping("/api/v1/departments")
@CrossOrigin(origins = "https://proyectofin-three.vercel.app/")
@Tag(
        name = "Departments"
)
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<List<DepartmentEntity>> getDepartment(){
        return ResponseEntity.ok(departmentService.obtenerDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DepartmentEntity>> getDepartmentById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.obtenerDepartmentPorId(id));
    }

    @PostMapping
    public ResponseEntity<DepartmentEntity> createDepartment(@RequestBody DepartmentEntity department){
        return ResponseEntity.ok(departmentService.guardarDepartment(department));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentEntity> updateDepartment(@RequestBody DepartmentEntity department, @PathVariable Long id){
        department.setDepartmentId(id);
        return ResponseEntity.ok(departmentService.actualizarDepartment(department));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DepartmentEntity> deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }

}

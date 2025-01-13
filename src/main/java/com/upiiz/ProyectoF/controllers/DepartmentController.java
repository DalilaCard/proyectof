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
//    public List<DepartmentEntity> getAllDepartments(Authentication authentication) {
//        String userId = authentication.name(); // Usuario autenticado
//        return service.getAllDepartments(userId);
//    }

    @GetMapping("/{id}")

    public ResponseEntity<Optional<DepartmentEntity>> getDepartmentById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.obtenerDepartmentPorId(id));
    }


//    @PreAuthorize("hasAuthority('READ')")
//    public ResponseEntity<DepartmentEntity> getDepartmentById(@PathVariable Integer id) {
//        DepartmentEntity department = service.getDepartmentById(id);
//        return (department != null) ? ResponseEntity.ok(department) : ResponseEntity.notFound().build();
//    }

    @PostMapping

    public ResponseEntity<DepartmentEntity> createDepartment(@RequestBody DepartmentEntity department){
        return ResponseEntity.ok(departmentService.guardarDepartment(department));
    }
//    @PreAuthorize("hasAuthority('CREATE')")
//    public ResponseEntity<DepartmentEntity> createDepartment(@RequestBody DepartmentEntity department, Authentication authentication) {
//        String userId = authentication.name(); // Asignar el usuario autenticado al departamento
//        department.setUserId(userId);
//        return ResponseEntity.ok(service.createDepartment(department));
//    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentEntity> updateDepartment(@RequestBody DepartmentEntity department, @PathVariable Long id){
        department.setDepartmentId(id);
        return ResponseEntity.ok(departmentService.actualizarDepartment(department));

    }


//    @PreAuthorize("hasAuthority('UPDATE')")
//    public ResponseEntity<DepartmentEntity> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentEntity department) {
//        DepartmentEntity updatedDepartment = service.updateDepartment(id, department);
//        return ResponseEntity.ok(updatedDepartment);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DepartmentEntity> deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
//    @PreAuthorize("hasAuthority('DELETE')")
//    public ResponseEntity<Void> deleteDepartment(@PathVariable Integer id) {
//        service.deleteDepartment(id);
//        return ResponseEntity.noContent().build();
//    }
}

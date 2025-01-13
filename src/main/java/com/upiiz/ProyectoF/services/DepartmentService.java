package com.upiiz.ProyectoF.services;

import com.upiiz.ProyectoF.entities.DepartmentEntity;
import com.upiiz.ProyectoF.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;


import java.util.List;
import java.util.Optional;
@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<DepartmentEntity> obtenerDepartments() {
        return departmentRepository.findAll();
    }

    public DepartmentEntity guardarDepartment(DepartmentEntity department) {
        return departmentRepository.save(department);
    }

    public Optional<DepartmentEntity> obtenerDepartmentPorId(Long id) {
        return Optional.ofNullable(departmentRepository.findDepartmentEntityById(id));
    }

    @Transactional
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public DepartmentEntity actualizarDepartment(DepartmentEntity department) {
        return departmentRepository.save(department);
    }

}

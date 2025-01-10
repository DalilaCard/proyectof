package com.upiiz.ProyectoF.repositories;
import com.upiiz.ProyectoF.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    List<DepartmentEntity> findByUserId(String userId); // Obtiene los departamentos de un usuario específico
}

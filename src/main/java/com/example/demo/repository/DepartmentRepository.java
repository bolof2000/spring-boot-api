package com.example.demo.repository;


import com.example.demo.entity.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long> {

    DepartmentModel findByDepartmentId(Long departmentId);
}

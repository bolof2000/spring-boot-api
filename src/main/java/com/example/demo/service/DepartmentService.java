package com.example.demo.service;

import com.example.demo.entity.DepartmentModel;
import com.example.demo.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentModel saveDepartment(DepartmentModel department) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public DepartmentModel findDepartmentById(Long departmentId) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }

    public List<DepartmentModel> findAllDepartment() {
        
        return departmentRepository.findAll();
    }
}

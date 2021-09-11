package com.example.demo.repository;


import com.example.demo.entity.DepartmentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<DepartmentModel, Long> {

    DepartmentModel findByDepartmentId(Long departmentId);
}

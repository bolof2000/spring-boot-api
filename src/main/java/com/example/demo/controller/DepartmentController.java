package com.example.demo.controller;


import com.example.demo.entity.DepartmentModel;
import com.example.demo.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/")
    public DepartmentModel saveDepartment(@RequestBody DepartmentModel department) {
        log.info("Inside saveDepartment method of DepartmentController");
        return  departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public DepartmentModel findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }

    @GetMapping("/")
    public List<DepartmentModel> findAllDepartment(){
        return departmentService.findAllDepartment();
    }

    @PostMapping("/publish")
    public DepartmentModel publishDepartment(@RequestBody DepartmentModel department) {
      DepartmentModel departmentD =  departmentService.saveDepartment(department);
      template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY,departmentD);
      return departmentD;

    }


}

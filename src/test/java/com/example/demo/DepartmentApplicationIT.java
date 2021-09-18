package com.example.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import utils.DataGenerator;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentApplicationIT {

   @Autowired
   private MockMvc mockMvc;


   private static MySQLContainer container = (MySQLContainer) new MySQLContainer("mysql:latest")
           .withReuse(true);


   @BeforeAll
   public static void setup(){
      container.start();
   }



   @DynamicPropertySource
   public static void overridePros(DynamicPropertyRegistry registry){

      registry.add("spring.datasource.url",container::getJdbcUrl);
      registry.add("spring.datasource.username",container::getUsername);
      registry.add("spring.datasource.password",container::getPassword);
   }


   @Test
   public void createDepartment() throws Exception {
      mockMvc.perform(MockMvcRequestBuilders.post("/departments/")
              .contentType(MediaType.APPLICATION_JSON).content(DataGenerator.departmentTestData())
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk())
              .andReturn();
   }


   @Test
   public void getAllDepartments() throws Exception {

      mockMvc.perform(MockMvcRequestBuilders.get("/departments/")
      .accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk())
              .andReturn();

   }

}

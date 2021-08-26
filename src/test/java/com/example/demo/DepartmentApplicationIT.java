package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import utils.DataGenerator;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentApplicationIT {

   @Autowired
   private MockMvc mockMvc;


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

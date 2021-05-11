package com.workmotion.employee.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import com.workmotion.employee.controllers.api.EmployeeController;
import com.workmotion.employee.models.Employee;
import com.workmotion.employee.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    //note: i used this dummy action (url) because i use in-memory database and there is stored data to compare

    @Test
    public void dummyEmployeeData_basic() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/dummy-employee-data")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1,\"name\":\"Ahmed Sakr\",\"email\":\"prog.sakr@gmail.com\",\"age\":26,\"state\":1,\"contract\":\"contract\"}"))
                .andReturn();
    }

//    @Test
//    public void retrieveAllEmployees_basic() throws Exception {
//        when(employeeService.employees()).thenReturn(
//                Arrays.asList(new Employee(1,"Ahmed Sakr","prog.sakr@gmail.com",26,1,"contract1"),
//                        new Employee(2,"Sara Ahmed","sara@gmail.com",20,3,"contract2"))
//        );
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .get("/api/dummy-employee-data-basic")
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().json("[{id:1,name:Ahmed Sakr,email:prog.sakr@gmail.com,age:26,state:1,contract:contract1}, " +
//                        "{id:3,name:Sara Ahmed,email:sara@gmail.com,age:20,state:2,contract:contract3}]"))
//                .andReturn();
//        //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
//
//    }

    @Test
    public void retrieveAllEmployes_no_employees() throws Exception {
        when(employeeService.employees()).thenReturn(
                Arrays.asList()
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/employees")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[]"))
                .andReturn();
        //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

    }

}

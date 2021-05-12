package com.workmotion.employee.controllers.api;

import com.workmotion.employee.models.Employee;
import com.workmotion.employee.services.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "EmployeeController", description = "It is a REST APIs related to Employee Entity!!!!")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /*
     * A method that handle '/employees' path.
     * Request method = 'POST'.
     * Method Name = 'saveEmployee'.
     * save new Employee
     */
    @PostMapping("/employees")
    private ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.saveOrUpdate(employee);
        return ResponseEntity.created(null).body(createdEmployee);
    }

    /*
     * A method that handle '/employees' path.
     * Request method = 'PUT'.
     * Method Name = 'changeEmployeeState'.
     * save new Employee
     */
    @PutMapping("/employees/{id}/change-state")
    private ResponseEntity<Employee> changeEmployeeState(@RequestBody Employee employeeDetails,@PathVariable(value = "id") long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        employee.setState(employeeDetails.getState());

        final Employee updatedEmployee = employeeService.saveOrUpdate(employee);
        return ResponseEntity.ok().body(updatedEmployee);
    }



    /*
     * A method that handle '/employees' path.
     * Request method = 'GET'.
     * Method Name = 'employees'.
     * get all employees
     */
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> employees() {
        List<Employee> employees =  employeeService.employees();
        return ResponseEntity.ok().body(employees);
    }


    /*
     * A method that handle '/employees/{id}' path.
     * Request method = 'GET'.
     * Method Name = 'getEmployee'.
     * a method that get specific employee
     */
    @GetMapping("/employees/{id}")
    private ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {

        Employee employee =  employeeService.getEmployeeById(id);
        return ResponseEntity.ok().body(employee);
    }

    /*
     * A method that handle '/employees/{id}s' path.
     * Request method = 'GET'.
     * Method Name = 'deleteEmployee'.
     * a method that get all employees
     */
    @DeleteMapping("/employees/{id}")
    private void deleteEmployee(@PathVariable("id") int id) {
        employeeService.delete(id);
    }



    //================================================================== method used in test to simulate data because i use in-memory database

    /*
     * A method that handle '/dummy-employee-data' path.
     * Request method = 'GET'.
     * Method Name = 'dummy'.
     * for test purposes
     */
    @GetMapping("/dummy-employee-data")
    private ResponseEntity<Employee> dummy() {
        Employee employee = new Employee(1,"Ahmed Sakr","prog.sakr@gmail.com",26,1,"contract");
        return ResponseEntity.ok().body(employee);
    }

    /*
     * A method that handle '/dummy-employee-data-basic' path.
     * Request method = 'GET'.
     * Method Name = 'dummy'.
     * for test purposes
     */

    @GetMapping("/dummy-employee-data-basic")
    private ResponseEntity<ArrayList<Employee>> dummyBasic() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"Ahmed Sakr","prog.sakr@gmail.com",26,1,"contract1"));
        employees.add(new Employee(3,"Sara Ahmed","sara@gmail.com",20,2,"contract3"));
        return ResponseEntity.ok().body(employees);
    }


}

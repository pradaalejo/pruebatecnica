package com.pruebatecnica.pruebatecnica.controller;


import com.pruebatecnica.pruebatecnica.models.modelsresponse.Employee;
import com.pruebatecnica.pruebatecnica.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping(value = "employee")
public class EmployeeController {


    @Autowired
    EmployeeService emplyeeService;


    @PostMapping(value = "/postemployee" )
    public @ResponseBody  String postEmployee(@Valid @RequestBody Employee employee) {
        return  emplyeeService.postEmployee(employee);
    }

    @GetMapping(value = "/getemployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Optional<Employee> getEmployee(@RequestHeader Integer idEmpleado ) {
        return  emplyeeService.getEmployee(idEmpleado);
    }


/*    @PutMapping(value = "/postemployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public String putEmployee() {
        return  emplyeeService.getEmployee();
    }*/


  /*  @DeleteMapping(value = "/postemployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteEmployee() {
        return  emplyeeService.getEmployee();
    }*/


}

package com.pruebatecnica.pruebatecnica.controller;


import com.pruebatecnica.pruebatecnica.models.modelsrequest.EmployeePay;
import com.pruebatecnica.pruebatecnica.models.modelsresponse.Employee;
import com.pruebatecnica.pruebatecnica.models.modelsresponse.EmployeePayResponse;
import com.pruebatecnica.pruebatecnica.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Optional;

/**
 * @Author John Alexander Arguello Ospina
 * **/


@RestController
@RequestMapping(value = "employee")
public class EmployeeController {


    @Autowired
    EmployeeService emplyeeService;


    @PostMapping(value = "/postemployee" )
    public @ResponseBody  Employee postEmployee(@Valid @RequestBody Employee employee) {
        return  emplyeeService.postEmployee(employee);
    }

    @GetMapping(value = "/getemployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Optional<Employee> getEmployee(@RequestHeader Integer idEmpleado) {
        return  emplyeeService.getEmployee(idEmpleado);
    }


    @PostMapping(value = "/postemployeepay" )
    public @ResponseBody EmployeePayResponse postEmployeepay(@Valid @RequestBody EmployeePay employeePay) throws ParseException {
        return  emplyeeService.postEmployeepay(employeePay);
    }

    @PutMapping(value = "/putemployee" )
    public @ResponseBody  Employee putEmployee(@Valid @RequestBody Employee employee){
          return  emplyeeService.putEmployee(employee);
    }


    @DeleteMapping(value = "/deletetemployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteEmployee(@RequestHeader Integer idEmpleado) {
        return  emplyeeService.deleteEmployee(idEmpleado);
    }


}

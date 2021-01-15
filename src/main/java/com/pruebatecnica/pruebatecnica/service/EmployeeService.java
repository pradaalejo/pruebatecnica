package com.pruebatecnica.pruebatecnica.service;

import com.pruebatecnica.pruebatecnica.models.modelsresponse.Employee;

import java.util.Optional;

public interface EmployeeService {


    public Optional<Employee> getEmployee(Integer idEmpleado);
    public String postEmployee(Employee employee);

}

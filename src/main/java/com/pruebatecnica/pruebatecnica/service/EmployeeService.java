package com.pruebatecnica.pruebatecnica.service;

import com.pruebatecnica.pruebatecnica.models.modelsrequest.EmployeePay;
import com.pruebatecnica.pruebatecnica.models.modelsresponse.Employee;
import com.pruebatecnica.pruebatecnica.models.modelsresponse.EmployeePayResponse;

import java.text.ParseException;
import java.util.Optional;

public interface EmployeeService {


    public Optional<Employee> getEmployee(Integer idEmpleado);
    public Employee postEmployee(Employee employee);
    public EmployeePayResponse postEmployeepay(EmployeePay employeePay) throws ParseException;
    public Employee putEmployee(Employee employee);
    public String deleteEmployee(Integer id);

}

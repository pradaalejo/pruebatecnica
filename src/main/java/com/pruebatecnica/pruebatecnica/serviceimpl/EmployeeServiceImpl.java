package com.pruebatecnica.pruebatecnica.serviceimpl;

import com.pruebatecnica.pruebatecnica.connectionservice.repository.EmployeeRepository;
import com.pruebatecnica.pruebatecnica.models.modelsresponse.Employee;
import com.pruebatecnica.pruebatecnica.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public @ResponseBody
    Optional<Employee> getEmployee(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public String postEmployee(Employee employee) {

        try {
            employeeRepository.save(employee);

        }catch (Exception e) {
            throw e;
        }
        return "Registro guardado";
    }


}

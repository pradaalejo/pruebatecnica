package com.pruebatecnica.pruebatecnica.connectionservice.repository;

import com.pruebatecnica.pruebatecnica.models.modelsresponse.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}

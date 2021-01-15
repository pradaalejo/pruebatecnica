package com.pruebatecnica.pruebatecnica.serviceimpl;

import com.pruebatecnica.pruebatecnica.connectionservice.repository.EmployeeRepository;
import com.pruebatecnica.pruebatecnica.models.modelsrequest.EmployeePay;
import com.pruebatecnica.pruebatecnica.models.modelsresponse.Employee;
import com.pruebatecnica.pruebatecnica.models.modelsresponse.EmployeePayResponse;
import com.pruebatecnica.pruebatecnica.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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
    public Employee postEmployee(Employee employee) {

        try {

            employeeRepository.save(employee);

        }catch (Exception e) {
            throw e;
        }
        return employee;
    }

    @Override
    public EmployeePayResponse postEmployeepay(EmployeePay employeePay) throws ParseException {
        EmployeePayResponse res = new EmployeePayResponse();

        try {

            Optional<Employee> employeeCalculartion = employeeRepository.findById(employeePay.getId());

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
            String fechaParametros =  employeePay.getAnioPago()+"-"+employeePay.getMesPago()+"-"+ "01";
            Date fecha1 = employeeCalculartion.get().getFechaIngreso();

            Date fechaFinal2 = formato.parse(fechaParametros);

            long diffInMillies = Math.abs(fechaFinal2.getTime() - fecha1.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);


            final double díasMes = 30;

            BigDecimal mesesApagar =  BigDecimal.valueOf(diff / díasMes);
            BigDecimal totalAPagar =  employeeCalculartion.get().getSalarioBase().multiply(mesesApagar);

            res.setId(employeeCalculartion.get().getId());
            res.setNombres(employeeCalculartion.get().getNombres());
            res.setApellidos(employeeCalculartion.get().getApellidos());
            res.setFechaIngreso(employeeCalculartion.get().getFechaIngreso());
            res.setValorApaqar(totalAPagar);

        }catch (Exception e) {

            throw e;
        }

        return res;
    }


    @Override
    public Employee putEmployee(Employee employee) {
        try {


            Optional<Employee> employeeCalculartion = employeeRepository.findById(employee.getId());

            if(!employeeCalculartion.equals(null)) {

                employeeRepository.delete(employee);
                employeeRepository.save(employee);

            } else {

                System.out.println("El registro no existe");
            }
        }catch (Exception e) {
            throw e;
        }
        return employee;
    }

    @Override
    public String deleteEmployee(Integer id) {
        Optional<Employee> employeeCalculartion = employeeRepository.findById(id);

        if(!employeeCalculartion.equals(null)) {

            Employee envio = new Employee();
            envio.setId(employeeCalculartion.get().getId());
            envio.setNombres(employeeCalculartion.get().getNombres());
            envio.setApellidos(employeeCalculartion.get().getApellidos());
            employeeRepository.delete(envio);

        } else {

            System.out.println("El registro no existe");
        }
        return "se eliminó el elemento";
    }


}

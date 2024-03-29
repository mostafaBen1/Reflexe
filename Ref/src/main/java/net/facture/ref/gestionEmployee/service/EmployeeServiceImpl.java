package net.facture.ref.gestionEmployee.service;

import net.facture.ref.gestionEmployee.model.Employee;
import net.facture.ref.gestionEmployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository emp;

    @Override
    public List<Employee> getAllEmployees() {

        return emp.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        emp.save(employee);

    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> opt = emp.findById(id);
        Employee employee = null;
        if (opt.isPresent()) {
            employee = opt.get();
        } else {
            throw new RuntimeException("Employee not found for id :: " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        emp.deleteById(id);


    }
}

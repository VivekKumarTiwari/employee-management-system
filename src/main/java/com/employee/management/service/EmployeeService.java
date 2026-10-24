package com.employee.management.service;
import com.employee.management.dtos.EmployeeDto;
import java.util.List;
public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employee);
    EmployeeDto updateEmployee(Long id, EmployeeDto employee);
    void deleteEmployee(Long id);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
}

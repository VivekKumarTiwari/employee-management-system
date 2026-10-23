package com.employee.management.service;

import com.employee.management.dtos.EmployeeDto;
import com.employee.management.entity.Employee;
import com.employee.management.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Audited;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Audited
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        // Convert DTO to Entity
        Employee employee = modelMapper.map(employeeDto, Employee.class);

        // Save Entity
        Employee savedEmployee = employeeRepository.save(employee);

        // Convert back to DTO
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employee.setId(existing.getId());

        // Update Entity
        Employee updateEmployee = employeeRepository.save(employee);

        return modelMapper.map(updateEmployee,EmployeeDto.class);

       /* existing.setName(employeeDto.getName());
        existing.setEmail(employeeDto.getEmail());
        existing.setPhone(employee.getPhone());
        existing.setDesignation(employee.getDesignation());
        existing.setSalary(employee.getSalary());
        existing.setUpdatedAt(employee.getUpdatedAt());*/

    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(emp->modelMapper.map(emp,EmployeeDto.class)).collect(Collectors.toList());
    }
}

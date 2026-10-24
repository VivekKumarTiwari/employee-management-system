package com.employee.management.dtos;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EmployeeDto {

    private Long id;

    private String name;

    private String email;

    private String phone;

/*    private String designation;*/

    private Double salary;

    private Long departmentId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

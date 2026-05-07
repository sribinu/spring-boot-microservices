package com.sribinu.employee_service.service;

import com.sribinu.employee_service.dto.APIResponseDto;
import com.sribinu.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long id);
}

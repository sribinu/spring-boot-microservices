package com.sribinu.employee_service.controller;

import com.sribinu.employee_service.dto.APIResponseDto;
import com.sribinu.employee_service.dto.EmployeeDto;
import com.sribinu.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    // Build Save Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(
                employeeService.saveEmployee(employeeDto),
                HttpStatus.CREATED
        );
    }

    // Build Get employee REST API
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        return new ResponseEntity<>(
                employeeService.getEmployeeById(employeeId),
                HttpStatus.OK
        );
    }

}

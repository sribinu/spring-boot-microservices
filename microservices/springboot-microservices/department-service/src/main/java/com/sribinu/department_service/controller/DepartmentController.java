package com.sribinu.department_service.controller;

import com.sribinu.department_service.dto.DepartmentDto;
import com.sribinu.department_service.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    // Build save department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(
                departmentService.saveDepartment(departmentDto),
                HttpStatus.CREATED
        );
    }

    // Build get department REST API
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String code) {
        return new ResponseEntity<>(
                departmentService.getDepartmentByCode(code),
                HttpStatus.OK
        );
    }
}

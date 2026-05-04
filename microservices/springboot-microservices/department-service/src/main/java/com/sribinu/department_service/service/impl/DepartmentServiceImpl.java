package com.sribinu.department_service.service.impl;

import com.sribinu.department_service.dto.DepartmentDto;
import com.sribinu.department_service.entity.Department;
import com.sribinu.department_service.repository.DepartmentRepository;
import com.sribinu.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // convert department dto to department jpa entity
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );

        departmentRepository.save(department);


        return null;
    }
}

package com.sribinu.department_service.service.impl;

import com.sribinu.department_service.dto.DepartmentDto;
import com.sribinu.department_service.entity.Department;
import com.sribinu.department_service.exception.NotFoundException;
import com.sribinu.department_service.mapper.AutoDepartmentMapper;
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
//        Department department = new Department(
//                departmentDto.getId(),
//                departmentDto.getDepartmentName(),
//                departmentDto.getDepartmentDescription(),
//                departmentDto.getDepartmentCode()
//        );

        Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

//        DepartmentDto savedDepartmentDto = new DepartmentDto(
//                savedDepartment.getId(),
//                savedDepartment.getDepartmentName(),
//                savedDepartment.getDepartmentDescription(),
//                savedDepartment.getDepartmentCode()
//        );

        DepartmentDto savedDepartmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        if (department == null) {
            throw new NotFoundException("No department found for the code: " + departmentCode);
        }

//        DepartmentDto departmentDto = new DepartmentDto(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );

        DepartmentDto departmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);

        return departmentDto;
    }
}

package com.sribinu.department_service.mapper;

import com.sribinu.department_service.dto.DepartmentDto;
import com.sribinu.department_service.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {

    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

    Department mapToDepartment(DepartmentDto departmentDto);
    DepartmentDto mapToDepartmentDto(Department department);
}

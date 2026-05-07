package com.sribinu.employee_service.service.impl;

import com.sribinu.employee_service.dto.APIResponseDto;
import com.sribinu.employee_service.dto.DepartmentDto;
import com.sribinu.employee_service.dto.EmployeeDto;
import com.sribinu.employee_service.entity.Employee;
import com.sribinu.employee_service.exception.NotFoundException;
import com.sribinu.employee_service.mapper.AutoEmployeeMapper;
import com.sribinu.employee_service.repository.EmployeeRepository;
import com.sribinu.employee_service.service.APIClient;
import com.sribinu.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

//    private RestTemplate restTemplate;
//    private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

//        Employee employee = new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail()
//        );

        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

//        EmployeeDto savedEmployeeDto = new EmployeeDto(
//                savedEmployee.getId(),
//                savedEmployee.getFirstName(),
//                savedEmployee.getLastName(),
//                savedEmployee.getEmail()
//        );

        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No employee found for ID: " + id)
        );

//        EmployeeDto employeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );

        ///  Using RestTemplate
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
//                "http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class
//        );
//
//        DepartmentDto departmentDto = responseEntity.getBody();

        ///  Using WebClient
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        ///  Using FeignClient
        DepartmentDto departmentDto = apiClient.getDepartmentByDepartmentCode(employee.getDepartmentCode());

        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto(
                employeeDto,
                departmentDto
        );

        return apiResponseDto;
    }
}

package com.study.springboot202210younggyu.service;

import com.study.springboot202210younggyu.service.repository.EmployeeRepository;
import com.study.springboot202210younggyu.web.dto.EmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;


    public int addEmployee(EmpDto empDto) {

        employeeRepository.saveEmployee(empDto);
        System.out.println("후 : " + empDto);
        return empDto.getEmpId();
//        return employeeRepository.saveEmployee(empDto) > 0 ? empDto.getEmpId() : 0;

    }
}

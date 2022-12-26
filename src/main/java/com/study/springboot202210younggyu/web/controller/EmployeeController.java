package com.study.springboot202210younggyu.web.controller;

import com.study.springboot202210younggyu.service.EmployeeService;
import com.study.springboot202210younggyu.web.dto.CMRespDto;
import com.study.springboot202210younggyu.web.dto.EmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;


    @PostMapping("/api/emp")
    public ResponseEntity<?> addEmployee(@RequestBody EmpDto empDto){

//        return ResponseEntity
//                .created(URI.create("/api/emp/" + employeeService.addEmployee(empDto)))
//                .body(empDto);

        return ResponseEntity.created(null).body(new CMRespDto<>("직원등록완료", employeeService.addEmployee(empDto)));
    }
}

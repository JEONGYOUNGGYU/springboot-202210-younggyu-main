package com.study.springboot202210younggyu.repository;

import com.study.springboot202210younggyu.web.dto.EmpDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeRepository {
    public int saveEmployee(EmpDto empDto);

}

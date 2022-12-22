package com.study.springboot202210younggyu.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpDto {

    private int empId;
    private String empName;
    private int empAge;
    private String empPhone;


}

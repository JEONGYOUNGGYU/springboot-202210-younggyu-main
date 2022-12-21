package com.study.springboot202210younggyu.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder                    // 생성자
@NoArgsConstructor          // DTO면은 4개는 기본
@AllArgsConstructor         // 객체 생성자
@Data
public class CategoryDto {
    private int categoryId;
    private String categoryName;
    private String categoryOpt1;
    private String categoryOpt2;
}

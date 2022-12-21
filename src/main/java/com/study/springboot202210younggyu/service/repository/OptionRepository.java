package com.study.springboot202210younggyu.service.repository;

import com.study.springboot202210younggyu.web.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OptionRepository {

    public int saveCategory(CategoryDto categoryDto);

    public List<CategoryDto> getCategories();

    public int modifyCategory(CategoryDto categoryDto);
}

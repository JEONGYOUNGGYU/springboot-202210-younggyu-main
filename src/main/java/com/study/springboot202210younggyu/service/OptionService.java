package com.study.springboot202210younggyu.service;

import com.study.springboot202210younggyu.service.repository.OptionRepository;
import com.study.springboot202210younggyu.web.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    @Autowired
    private OptionRepository optionRepository;

    public int addCategory(CategoryDto categoryDto) {
        int categoryId = 0;
        System.out.println("데이터베이스에 insert 전 : " + categoryDto);
        optionRepository.saveCategory(categoryDto);
        System.out.println("데이터베이스에 insert 후 : " + categoryDto);
        return categoryDto.getCategoryId();
//      return optionRepository.saveCategory(categoryDto) > 0 ? categoryDto.getCategory() : 0;
    }

    public List<CategoryDto> getCategories(){

        return optionRepository.getCategories();
    }

    public void modifyCategory(int categoryId, CategoryDto categoryDto){
        categoryDto.setCategoryId(categoryId);
        optionRepository.modifyCategory(categoryDto);
    }
}

package com.study.springboot202210younggyu.web.dto.controller;

import com.study.springboot202210younggyu.service.OptionService;
import com.study.springboot202210younggyu.web.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/option")
public class OptionController {

    @Autowired
    private OptionService optionService;

    @PostMapping("/category")                                       //postman에서 post 딱 누르면 일로 데이터 들어옴
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto){
//        System.out.println(categoryDto);

        return ResponseEntity
                .created(URI.create("/api/option/category/" + optionService.addCategory(categoryDto)))
                .body(categoryDto);

    }

    @GetMapping("/categories")
    // =@RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.ok(optionService.getCategories());
    }

    @PutMapping("/category/{categoryId}")
        public ResponseEntity<?> modifyCategory(@PathVariable int categoryId, @RequestBody CategoryDto categoryDto){
        optionService.modifyCategory(categoryId, categoryDto);
            return ResponseEntity.ok(true);
        }
    }
    // category 하나만 들고 올 수 있어야 한다
    // user는 list형태로 들고 올 수 있어야 한다




    // client ↔ servlet ↔ handler mapping
    //  server                  ㅁ

    // ResponseEntity
    // http 못찾는다 405번
    // controller 위에 @Component가 있으면 IOC에 등록이 되어있다. 그래서 호출 가능
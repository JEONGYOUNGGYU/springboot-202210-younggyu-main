package com.study.springboot202210younggyu.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private Test1 test1;

    @Autowired
    private Test2 test2;

    @ResponseBody
    @GetMapping("/student")
    public String printStudent() {
        Student student = Student.builder()
                .studentId(2001)
                .studentName("김경민")
                .build();

        test1.print();
        test2.print();

        studentService.printStudentInfo(student);

        return null;
    }

}

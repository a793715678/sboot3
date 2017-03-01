package org.rico.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.rico.demo.Service.StudentService;
import org.rico.demo.domain.Student;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoufei on 2017/2/23.
 */
@Controller
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String toIndex(ModelMap modelMap) {
        Student student = this.studentService.getStudent(1L);
        modelMap.put("student", student);
        return "student/index";
    }

    @GetMapping("/student")
    @ResponseBody
    public Student ajaxStudent() {
        Student student = new Student(2L, "唐小峰", 23);
        return student;
    }

    @GetMapping("/students")
    @ResponseBody
    public List<Student> ajaxStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(2L, "唐小峰1", 23));
        students.add(new Student(3L, "唐小峰2", 24));
        students.add(new Student(4L, "唐小峰3", 25));
        return students;
    }
    @GetMapping("/img")
    @ResponseBody
    public byte[] img() throws IOException {
        InputStream inputStream = new BufferedInputStream(
                new FileInputStream(
                        new File("d:\\example.jpg")));
        return IOUtils.toByteArray(inputStream);
    }
    @RequestMapping("/modify/{id}")
    public String modify(@PathVariable Long id, ModelMap modelMap, String name , Integer age) {

//        Get // 跳转页面  POST // 表单提交

//        if(name == null && age = null ) {
//
//        } else {
//
//        }


        log.info("id = " + id);

        return "student/modify";
    }
    @RequestMapping("/doCreate")
    public String doCreate(String name, Integer age) {
        log.info("name = " + name);
        log.info("age = " + age);
        // 重定向
        return "redirect:index";
    }

}

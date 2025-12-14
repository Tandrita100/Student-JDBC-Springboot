package com.spring.student.controller;

import com.spring.student.dao.StudentDAO;
import com.spring.student.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentDAO studentDAO;

    public StudentController(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }

    @GetMapping("/{name}")
    public Student getStudentByName(@PathVariable String name){
        return studentDAO.getStudentByName(name);
    }

    @PostMapping
    public String addStudent(@RequestBody Student student){
        studentDAO.addStudent(student);
        return "Student added successfully";
    }

}

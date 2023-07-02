package com.example.universityManagment.controller;

import com.example.universityManagment.model.Department;
import com.example.universityManagment.model.Student;
import com.example.universityManagment.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    StudentService studentService;
    //Get All Student
    @GetMapping(value = "/")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    // Get Student by id
    @GetMapping(value = "/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        return studentService.getStudentById(studentId);
    }

    //add student
    @PostMapping(value = "/")
    public String addStudent(@Valid @RequestBody Student students){
       return studentService.addStudentList(students);

    }

    //update department
    @PutMapping(value = "/id/{studentId}/dept/{department}")
    public String updateDept(@PathVariable int studentId, @PathVariable Department department){
        return studentService.updateDepartment(studentId,department);
    }
    // delete student by id
    @DeleteMapping(value = "/{studentId}")
    public String deleteStudentById(@PathVariable int studentId){
        return studentService.deleteStudentById(studentId);
    }
}

package com.example.universityManagment.service;

import com.example.universityManagment.model.Department;
import com.example.universityManagment.model.Student;
import com.example.universityManagment.repository.IStudentDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentDao studentDao;
    //get all Student
    public List<Student> getAllStudent() {
        return (List<Student>) studentDao.findAll();
    }
    //get student by id
    public Student getStudentById(int studentId) {
        Optional<Student> stud= studentDao.findById(studentId);
        return stud.isPresent()? stud.get():null;
    }
    //add student
    public String addStudentList(Student students) {
        studentDao.save(students);
        return "Added Successfully";
    }
    //update department
    @Transactional
    public String updateDepartment(int studentId, Department department) {
        String departmentString = department.name();
        studentDao.updateDepartment(studentId,departmentString);
        return "Updated successfully";

    }
    //delete student by id
    public String deleteStudentById(int studentId) {
        studentDao.deleteById(studentId);
        return "Deleted Successfully";
    }


}

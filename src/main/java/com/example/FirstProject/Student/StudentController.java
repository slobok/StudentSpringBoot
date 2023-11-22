package com.example.FirstProject.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId")Long id){
        return this.studentService.getStudentById(id);
    }

    @GetMapping
    public List<Student> getStudents() { return this.studentService.getStudents();
    }
    //Maping student from request body

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        this.studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId")Long studentId){
         this.studentService.deleteStudent(studentId);
    }
}

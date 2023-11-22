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
    /*Jedan od nacina za update studenta */
    @PutMapping(path ="{studentId}")
    public void updateStudent(@PathVariable("studentId")Long studentId,
                              @RequestParam(required = false)String name,
                              @RequestParam(required = false)String email){
        this.studentService.updateStudent(studentId, name, email);
    }



    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId")Long studentId){
         this.studentService.deleteStudent(studentId);
    }
}

package com.example.FirstProject.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


//Service layer giving data back to api layer,to student controller
//@Component Moze komponent ali er je ovo servis bolje service
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        Optional<Student> studentOptional =  this.studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw  new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
    }


    public void deleteStudent(Long studentId) {
       boolean exists = this.studentRepository.existsById(studentId);
       if(!exists){
        throw new IllegalStateException("Student with" + studentId + "does not exists");
       }
       this.studentRepository.deleteById(studentId);
    }

    public Student getStudentById(Long studentID) {
        Optional<Student>  optionalStudent =  this.studentRepository.findById(studentID);
        if (optionalStudent.isEmpty()){
            throw new IllegalStateException("Not exists student with id" + studentID);
        }
        return optionalStudent.get();
    }
}
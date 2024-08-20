package com.example.demo.Controller;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

     @PostMapping("/addStudent")
     public Student postDetails(@RequestBody Student student){
         return studentService.saveDetails(student);
     }

     @GetMapping("/getStudent")
     public List<Student> getDetails(){
         return studentService.getAllDetails();
     }

     @GetMapping("/getStudentById/{id}")
     public Student fetchDetailsById(@PathVariable int id){
         return studentService.getStudentDetailsById(id);
     }

     @PutMapping("/updateStudent")
     public Student updateStudentDetails(@RequestBody Student student){
         return studentService.updateDetails(student);
     }

     @DeleteMapping("/deleteStudent/{id}")
     public String deleteStudentDetails(@PathVariable int id){
         return studentService.deleteStudent(id);
     }

}

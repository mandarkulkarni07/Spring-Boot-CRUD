package com.example.demo.Service;


import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student saveDetails(Student student){
        return studentRepo.save(student);
    }

    public List<Student> getAllDetails(){
        return studentRepo.findAll();
    }

    public Student getStudentDetailsById(int id){
        return studentRepo.findById(id).orElse(null);
    }

    public Student updateDetails(Student student){
        Student updateStudent= studentRepo.findById(student.getId()).orElse(null);
        if(updateStudent !=null){
            updateStudent.setMarks(student.getMarks());
            updateStudent.setName(student.getName());
            studentRepo.save(updateStudent);
            return updateStudent;
        }
        return null;
    }

    public String deleteStudent(int id){
        if(studentRepo.existsById(id)){
            studentRepo.deleteById(id);
            return "Deleted id " + id;
        }
        else return "invalid id " + id;
    }
}


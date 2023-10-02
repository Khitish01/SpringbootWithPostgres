package com.postgress.springwithpostgres.services;

import java.util.List;

import com.postgress.springwithpostgres.dao.StudentRepository;
import com.postgress.springwithpostgres.entities.StudentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<StudentData> getStudents(){
        List<StudentData> list=(List<StudentData>)this.studentRepository.findAll();
        return list;
    };

    public StudentData getStudentsById(long studentID){
        return this.studentRepository.findById(studentID);
    };

    public StudentData addStudent(StudentData data){
        StudentData student=this.studentRepository.save(data);
        return student;
    };
    public void deleteStudent(long id){
        this.studentRepository.deleteById(id);
    };
}

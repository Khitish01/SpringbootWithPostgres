package com.postgress.springwithpostgres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.postgress.springwithpostgres.entities.StudentData;
import com.postgress.springwithpostgres.services.StudentService;
import java.util.List;
import java.util.Optional;

@RestController
public class MyController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/home")
    public String home() {
        return "this is home page";
    }

    //	get the courses
    @GetMapping("/get_students")
    public ResponseEntity<List<StudentData>> getStudents(){

        List<StudentData> list= this.studentService.getStudents();
        if(list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/get_students/{studentId}")
    public ResponseEntity<StudentData> getStudentById(@PathVariable long studentId) {
        StudentData student=studentService.getStudentsById(studentId);
        if(student ==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(student));
//        this.studentService.getStudentsById(studentId);
    }

    @PostMapping("/create_student")
    public ResponseEntity<StudentData> addStudent(@RequestBody StudentData data) {
        StudentData student=null;
        try {
            student=this.studentService.addStudent(data);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
            return ResponseEntity.of(Optional.of(student));

        }
        catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
//        this.studentService.addStudent(data);
    }


}

package com.baez.introductionJPA.resources;

import com.baez.introductionJPA.models.Student;
import com.baez.introductionJPA.models.Subject;
import com.baez.introductionJPA.services.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ApiController {

    @Autowired
    private ServiceLayer serviceLayer;

    // STUDENTS ENDPOINTS ----------------------------------------------------------------------------------

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(serviceLayer.getStudentsRepo(), HttpStatus.OK);
    }

    @PostMapping(value = "/students")
    public ResponseEntity<Student> createStudent(
            @RequestBody Student student
    ) throws Exception {
        Student newStudent = serviceLayer.saveStudentRepo(student);
        return new ResponseEntity<>(newStudent, HttpStatus.OK);
    }

    @PostMapping(value = "/students/addSubj")
    public ResponseEntity<?> addSubject(
            @RequestParam Integer idStudent,
            @RequestParam Integer idSubject
    ) throws Exception {
        serviceLayer.addSubjectToStudent(idStudent, idSubject);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/students")
    public ResponseEntity<?> updateStudent(
            @RequestBody Student student
    ) throws Exception {
        serviceLayer.updateStudentRepo(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // SUBJECTS ENDPOINTS ----------------------------------------------------------------------------------

    @GetMapping(value = "/subjects")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return new ResponseEntity<>(serviceLayer.getSubjectsRepo(), HttpStatus.OK);
    }

    @PostMapping(value = "/subjects")
    public ResponseEntity<Subject> createSubject(
            @RequestBody Subject subject
    ) throws Exception {
        Subject newSubject = serviceLayer.saveSubjectRepo(subject);
        return new ResponseEntity<>(newSubject, HttpStatus.OK);
    }

}

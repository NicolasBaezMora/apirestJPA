package com.baez.introductionJPA.services;


import com.baez.introductionJPA.models.Student;
import com.baez.introductionJPA.models.Subject;
import com.baez.introductionJPA.repositories.StudentRepository;
import com.baez.introductionJPA.repositories.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class ServiceLayer {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    // STUDENTS SERVICES ---------------------------------------------------------------------------------
    public List<Student> getStudentsRepo() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student saveStudentRepo(Student student) throws Exception {
        try {
            return studentRepository.save(student);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception("No se pudo guardar el nuevo estudiante");
        }
    }

    @Transactional
    public void addSubjectToStudent(Integer idStudent, Integer idSubject) throws Exception {
        Student student = studentRepository.findById(idStudent)
                .orElseThrow(() -> new Exception("Estudiante no encontrado"));
        Subject subject = subjectRepository.findById(idSubject)
                .orElseThrow(() -> new Exception("Asignatura no encontrada"));
        student.getSubjects().add(subject);
    }

    @Transactional
    public void updateStudentRepo(Student student) throws Exception {
        try {
            studentRepository.customUpdateStudent(student.getName(), student.getLastname(), student.getId());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception("No se pudo guardar actualizar el estudiante");
        }
    }

    @Transactional
    public Student deleteStudentById(Integer idStudent) {
        try {
            Student studentFound = studentRepository.findById(idStudent)
                    .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
            studentRepository.delete(studentFound);
            return studentFound;
        } catch (Exception e) {
            throw new RuntimeException("No fue posible eliminar el estudiante");
        }
    }


    // SUBJECTS SERVICES ---------------------------------------------------------------------------------

    public List<Subject> getSubjectsRepo() {
        return subjectRepository.findAll();
    }

    public Subject saveSubjectRepo(Subject subject) throws Exception {
        try {
            return subjectRepository.save(subject);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception("No se pudo guardar la nueva asignatura");
        }
    }


}

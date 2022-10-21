package com.baez.introductionJPA.repositories;

import com.baez.introductionJPA.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Modifying
    @Query(
            value = "UPDATE students SET name = :name, lastname = :lastname WHERE id = :idStudent",
            nativeQuery = true
    )
    void customUpdateStudent(
            @Param(value = "name") String name,
            @Param(value = "lastname") String lastname,
            @Param(value = "idStudent") Integer idStudent
    );

//    @Modifying
//    @Query(
//            value = "UPDATE students SET name = ?1, lastname = ?2 WHERE id = ?3",
//            nativeQuery = true
//    )
//    void customUpdateStudent(
//            String name,
//            String lastname,
//            Integer idStudent
//    );

}

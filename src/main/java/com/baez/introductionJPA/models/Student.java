package com.baez.introductionJPA.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {

    @Id
    @SequenceGenerator(name = "seqIdStudent", sequenceName = "seq_id_student", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqIdStudent")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String lastname;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Subject> subjects = new ArrayList<>();

}

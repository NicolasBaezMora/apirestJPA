package com.baez.introductionJPA.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Subject {

    @Id
    @SequenceGenerator(name = "seqIdSubject", sequenceName = "seq_id_subject", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqIdSubject")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

}

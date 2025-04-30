package com.spring.study.GymSup.model;

import com.spring.study.GymSup.enums.DietType;
import com.spring.study.GymSup.enums.PersonRoutine;
import com.spring.study.GymSup.enums.Sex;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "person_table")
@Setter
@Getter
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer height;
    private Double weight;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Enumerated(EnumType.STRING)
    private DietType dietType;

    @Enumerated(EnumType.STRING)
    private PersonRoutine routine;

    public Person(){}
}

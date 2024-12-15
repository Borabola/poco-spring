package com.example.pocospring.model;

import jakarta.persistence.*;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
import lombok.*;

//import java.beans.Transient;
import java.time.LocalDate;
import java.time.Period;


//@Getter
//@Setter
//@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Data
//@Builder
@Entity
@Table
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    //@Column(name="person_firstName")
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @NonNull
    @Column(unique = true)
    private String email;
    @Transient
    private int age;

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}

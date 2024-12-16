package com.example.pocospring.model;

import jakarta.persistence.*;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;

//import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

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
    //@NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name is mandatory")
    private String firstName;
    @NotBlank(message = "Surname is mandatory")
    private String lastName;
    @Past(message = "Date should be past")
    private LocalDate dateOfBirth;
    //@NonNull
    @Column(unique = true)
    @Email(message = "Invalid Email")
    @NotBlank(message = "Email is mandatory")
    private String email;
    @Transient
    @Min(0)
    private int age;

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}

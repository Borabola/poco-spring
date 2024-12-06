package com.example.pocospring.model;

import lombok.*;


//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
@Data
@Builder
public class Person {
    private String firstName;
    private String lastName;
    @NonNull
    private String email;

    public Person (String firstName, String lastName, @NonNull String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


}

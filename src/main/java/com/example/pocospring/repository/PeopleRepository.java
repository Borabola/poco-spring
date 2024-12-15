package com.example.pocospring.repository;

import com.example.pocospring.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<Person, Long> {
    void deleteByEmail(String email);

    Person findByEmail(String email);
}

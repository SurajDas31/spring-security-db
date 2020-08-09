package com.virus.springsecuritydb.repository;

import com.virus.springsecuritydb.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    Optional<Person> findByName(String username);
}

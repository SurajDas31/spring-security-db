package com.virus.springsecuritydb.service;

import com.virus.springsecuritydb.entity.CustomUserDetails;
import com.virus.springsecuritydb.entity.Person;
import com.virus.springsecuritydb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> optionalPerson = personRepository.findByName(username);
        optionalPerson.orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        return optionalPerson.map(CustomUserDetails::new).get();
    }
}

package com.virus.springsecuritydb.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private int personId;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "person_role", joinColumns = @JoinColumn(name = "personId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> roles;

    public Person(Person person) {
        this.personId = person.getPersonId();
        this.name = person.getName();
        this.password = person.getPassword();
        this.roles = person.getRoles();
    }

    public Person() {
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

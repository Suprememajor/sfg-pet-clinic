package com.supremecorp.sfgpetclinic.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity{
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public Person() {
    }
}

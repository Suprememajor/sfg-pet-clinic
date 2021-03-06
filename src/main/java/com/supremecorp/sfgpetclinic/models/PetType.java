package com.supremecorp.sfgpetclinic.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "pet_type")
public class PetType extends BaseEntity {
    @Column(name = "name")
    private String name;

    public PetType() {
    }
}

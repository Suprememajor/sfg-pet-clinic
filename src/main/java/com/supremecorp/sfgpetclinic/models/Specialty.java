package com.supremecorp.sfgpetclinic.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by suprememajor on the 9/9/21
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "specialty")
public class Specialty extends BaseEntity{
    @Column(name = "description")
    private String description;

    public Specialty() {
    }
}

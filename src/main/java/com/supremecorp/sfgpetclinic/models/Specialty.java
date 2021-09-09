package com.supremecorp.sfgpetclinic.models;

/**
 * Created by suprememajor on the 9/9/21
 */
public class Specialty extends BaseEntity{
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

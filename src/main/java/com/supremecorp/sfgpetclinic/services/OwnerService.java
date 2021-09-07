package com.supremecorp.sfgpetclinic.services;

import com.supremecorp.sfgpetclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}

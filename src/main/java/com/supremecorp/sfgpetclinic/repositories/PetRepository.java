package com.supremecorp.sfgpetclinic.repositories;

import com.supremecorp.sfgpetclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by suprememajor on the 9/10/21
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
}

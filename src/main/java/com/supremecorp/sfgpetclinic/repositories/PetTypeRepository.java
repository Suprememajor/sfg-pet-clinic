package com.supremecorp.sfgpetclinic.repositories;

import com.supremecorp.sfgpetclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by suprememajor on the 9/10/21
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

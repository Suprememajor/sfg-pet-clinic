package com.supremecorp.sfgpetclinic.bootstrap;

import com.supremecorp.sfgpetclinic.models.Owner;
import com.supremecorp.sfgpetclinic.models.Pet;
import com.supremecorp.sfgpetclinic.models.PetType;
import com.supremecorp.sfgpetclinic.models.Vet;
import com.supremecorp.sfgpetclinic.services.OwnerService;
import com.supremecorp.sfgpetclinic.services.PetTypeService;
import com.supremecorp.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded Pet Types...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Nobert");
        owner1.setLastName("Etta");
        owner1.setAddress("Happicam, Molyko");
        owner1.setCity("Buea");
        owner1.setTelephone("671 888 553");

        Pet majorsPet = new Pet();
        majorsPet.setPetType(savedCatPetType);
        majorsPet.setOwner(owner1);
        majorsPet.setBirthdate(LocalDate.now());
        majorsPet.setName("Albedo");
        owner1.getPets().add(majorsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Gerard");
        owner2.setLastName("Micheals");
        owner2.setAddress("Happicam, Molyko");
        owner2.setCity("Buea");
        owner2.setTelephone("678 668 167");

        Pet gerardsPet = new Pet();
        gerardsPet.setPetType(savedDogPetType);
        gerardsPet.setOwner(owner2);
        gerardsPet.setBirthdate(LocalDate.now());
        gerardsPet.setName("Wolf");
        owner2.getPets().add(gerardsPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Prince");
        vet1.setLastName("Junior");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
         vet2.setFirstName("James");
        vet2.setLastName("Meyers");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}

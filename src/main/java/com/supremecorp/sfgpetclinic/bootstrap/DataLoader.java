package com.supremecorp.sfgpetclinic.bootstrap;

import com.supremecorp.sfgpetclinic.models.*;
import com.supremecorp.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded Pet Types...");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Nobert");
        owner1.setLastName("Etta");
        owner1.setAddress("Happicam, Molyko");
        owner1.setCity("Buea");
        owner1.setTelephone("671 888 553");

        Pet majorsPet = new Pet();
        majorsPet.setPetType(savedCatPetType);
        majorsPet.setOwner(owner1);
        majorsPet.setBirthDate(LocalDate.now());
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
        gerardsPet.setBirthDate(LocalDate.now());
        gerardsPet.setName("Wolf");
        owner2.getPets().add(gerardsPet);

        ownerService.save(owner2);

        Visit dogVisit = new Visit();
        dogVisit.setDate(LocalDate.now());
        dogVisit.setPet(gerardsPet);
        dogVisit.setDescription("Rabid dog");

        visitService.save(dogVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Prince");
        vet1.setLastName("Junior");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("James");
        vet2.setLastName("Meyers");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}

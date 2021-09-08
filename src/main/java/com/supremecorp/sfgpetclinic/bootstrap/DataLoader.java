package com.supremecorp.sfgpetclinic.bootstrap;

import com.supremecorp.sfgpetclinic.models.Owner;
import com.supremecorp.sfgpetclinic.models.Vet;
import com.supremecorp.sfgpetclinic.services.OwnerService;
import com.supremecorp.sfgpetclinic.services.VetService;
import com.supremecorp.sfgpetclinic.services.map.OwnerServiceMap;
import com.supremecorp.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Nobert");
        owner1.setLastName("Etta");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Gerard");
        owner2.setLastName("Micheals");

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
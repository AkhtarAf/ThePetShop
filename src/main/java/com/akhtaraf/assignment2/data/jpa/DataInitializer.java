package com.akhtaraf.assignment2.data.jpa;

import com.akhtaraf.assignment2.data.jpa.entity.PetEntity;
import com.akhtaraf.assignment2.data.jpa.repository.PetRepository;
import com.akhtaraf.assignment2.model.PetGender;
import com.akhtaraf.assignment2.model.PetType;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class DataInitializer {
    private final PetRepository petRepository;

    public DataInitializer(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @PostConstruct
    public void init() {
        // Create pet data

        // Data Of Milo
        PetEntity milo = new PetEntity("Milo", PetGender.MALE, PetType.CAT, true);
        petRepository.save(milo);

        // Data of Luca
        PetEntity luca = new PetEntity("Luca", PetGender.MALE, PetType.DOG, false);
        petRepository.save(luca);

        // Data of Bethany
        PetEntity bethany = new PetEntity("Bethany", PetGender.FEMALE, PetType.RABBIT, true);
        petRepository.save(bethany);

        // Data of Robert
        PetEntity robert = new PetEntity("Robert", PetGender.MALE, PetType.DOG, true);
        petRepository.save(robert);

        // Flush all the changes
        petRepository.flush();
    }
}

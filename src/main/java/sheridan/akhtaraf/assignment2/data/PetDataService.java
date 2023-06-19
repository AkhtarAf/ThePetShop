package sheridan.akhtaraf.assignment2.data;

import sheridan.akhtaraf.assignment2.model.Pet;
import sheridan.akhtaraf.assignment2.model.PetGender;
import sheridan.akhtaraf.assignment2.model.PetType;

import java.util.List;
import java.util.Optional;

public interface PetDataService {

    List<Pet> getAllPets();

    Optional<Pet> getPetById(int id);

    void createPetRecord(
            String name,
            PetGender petGender,
            PetType petType,
            Boolean vaccinated
    );

    void updatePetRecord(Pet updatedPet);

    void deletePetRecord(Integer id);
}

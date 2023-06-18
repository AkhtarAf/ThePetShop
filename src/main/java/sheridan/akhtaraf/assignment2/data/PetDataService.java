package sheridan.akhtaraf.assignment2.data;

import sheridan.akhtaraf.assignment2.model.Pet;
import java.util.List;
import java.util.Optional;

public interface PetDataService {

    List<Pet> getAllPets();

    Optional<Pet> getPetById(int id);
}

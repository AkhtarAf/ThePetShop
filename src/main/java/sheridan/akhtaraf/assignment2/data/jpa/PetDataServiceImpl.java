package sheridan.akhtaraf.assignment2.data.jpa;

import sheridan.akhtaraf.assignment2.data.PetDataService;
import sheridan.akhtaraf.assignment2.data.jpa.entity.PetEntity;
import sheridan.akhtaraf.assignment2.data.jpa.repository.PetRepository;
import sheridan.akhtaraf.assignment2.model.Pet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetDataServiceImpl implements PetDataService {

    private final Logger log = LoggerFactory.getLogger(PetDataServiceImpl.class);
    private final PetRepository repository;

    public PetDataServiceImpl(PetRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pet> getAllPets() {
        log.trace("getAllPets() is being called.");
        return repository.findAll()
                .stream()
                .map(e -> new Pet(e.getId(), e.getName(), e.getPetGender(), e.getPetType(), e.getVaccinated()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Optional<Pet> getPetById(int id) {
        log.trace("getPetById() is being called");
        log.debug("id =" + id);

        Optional<PetEntity> optionalPetEntity = repository.findById(id);

        if(optionalPetEntity.isPresent()) {
            PetEntity petEntity = optionalPetEntity.get();
            Pet pet = new Pet(
                    petEntity.getId(),
                    petEntity.getName(),
                    petEntity.getPetGender(),
                    petEntity.getPetType(),
                    petEntity.getVaccinated()
            );
            return Optional.of(pet);
        }

        return Optional.empty();
    }
}

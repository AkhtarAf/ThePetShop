package sheridan.akhtaraf.assignment2.data.jpa;

import sheridan.akhtaraf.assignment2.data.PetDataService;
import sheridan.akhtaraf.assignment2.data.jpa.entity.PetEntity;
import sheridan.akhtaraf.assignment2.data.jpa.repository.PetRepository;
import sheridan.akhtaraf.assignment2.model.Pet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sheridan.akhtaraf.assignment2.model.PetGender;
import sheridan.akhtaraf.assignment2.model.PetType;

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

    @Override
    public void createPetRecord(
            String name,
            PetGender petGender,
            PetType petType,
            Boolean vaccinated
    ) {
        log.trace("createPetRecord() Called.");
        log.debug("Created data of name = " + name);

        PetEntity newPetData = new PetEntity(
                name,
                petGender,
                petType,
                vaccinated
        );

        repository.save(newPetData);
    }

    @Override
    public void updatePetRecord(Pet updatedPet) {
        log.trace("updatePetRecord() called.");
        log.debug("Updated data of id = " + updatedPet.id());

        Optional<PetEntity> optionalPetEntity = repository.findById(updatedPet.id());

        if(optionalPetEntity.isPresent()) {
            PetEntity entityToUpdate = optionalPetEntity.get();

            entityToUpdate.setName(updatedPet.name());
            entityToUpdate.setPetGender(updatedPet.petGender());
            entityToUpdate.setPetType(updatedPet.petType());
            entityToUpdate.setVaccinated(updatedPet.vaccinated());

            repository.save(entityToUpdate);
        }
    }

    @Override
    public void deletePetRecord(Integer id) {
        Optional<PetEntity> optionalPetEntity = repository.findById(id);

        if(optionalPetEntity.isPresent()) {
            PetEntity entityToDelete = optionalPetEntity.get();
            repository.delete(entityToDelete);
        }

    }
}

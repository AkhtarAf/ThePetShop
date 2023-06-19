package sheridan.akhtaraf.assignment2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sheridan.akhtaraf.assignment2.data.PetDataService;
import sheridan.akhtaraf.assignment2.data.jpa.entity.PetEntity;
import sheridan.akhtaraf.assignment2.model.Pet;
import sheridan.akhtaraf.assignment2.model.PetGender;
import sheridan.akhtaraf.assignment2.model.PetType;

import java.util.Map;


@Controller
@RequestMapping("/pet")
public class PetEntryController {
    private final Logger log = LoggerFactory.getLogger(HomeController.class);
    private final PetDataService petDataService;

    public PetEntryController(PetDataService petDataService) {
        this.petDataService = petDataService;
    }

    @PostMapping(
            path="/insert"
    )
    String petEntry(
            @RequestParam String name,
            @RequestParam(defaultValue = "MALE") PetGender petGender,
            @RequestParam(defaultValue = "DOG") PetType petType,
            @RequestParam(defaultValue = "false") Boolean vaccinated
    ) {
        log.trace("Pet Record Insert is being called.");
        log.debug(String.valueOf(petGender));
        petDataService.createPetRecord(
                name,
                petGender,
                petType,
                vaccinated
        );

        log.debug("Created.");
        return "success";
    }

}

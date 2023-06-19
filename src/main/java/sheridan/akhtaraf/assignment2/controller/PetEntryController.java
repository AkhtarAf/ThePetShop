package sheridan.akhtaraf.assignment2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sheridan.akhtaraf.assignment2.data.PetDataService;
import sheridan.akhtaraf.assignment2.data.jpa.entity.PetEntity;
import sheridan.akhtaraf.assignment2.model.DeleteRequest;
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

    @PostMapping("/insert")
    ModelAndView insert(
            @RequestParam String name,
            @RequestParam(defaultValue = "FEMALE") PetGender petGender,
            @RequestParam(defaultValue = "DOG") PetType petType,
            @RequestParam(defaultValue = "false") Boolean vaccinated
    ) {
        log.trace("Pet Record Insert is being called.");
        petDataService.createPetRecord(
                name,
                petGender,
                petType,
                vaccinated
        );

        log.debug("Created.");
        return new ModelAndView("success", "changeType", "created");
    }

    @PostMapping("/update")
    ModelAndView update(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam(defaultValue = "DOG") PetType petType,
            @RequestParam(defaultValue = "FEMALE") PetGender petGender,
            @RequestParam(defaultValue = "false") Boolean vaccinated
    ) {
        log.trace("Pet Record Update is being called.");

        Pet toUpdatedPetRecord = new Pet(id, name, petGender, petType, vaccinated);
        petDataService.updatePetRecord(toUpdatedPetRecord);

        return new ModelAndView("success", "changeType", "updated");
    }

    @PostMapping(
            value = "/delete"
    )
    ModelAndView delete(@RequestParam Integer id) {
        log.trace("Pet Record Delete is being called.");

        petDataService.deletePetRecord(id);

        return new ModelAndView("success", "changeType", "deleted");
    }

}

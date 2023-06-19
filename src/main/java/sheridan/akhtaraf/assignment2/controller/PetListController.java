package sheridan.akhtaraf.assignment2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sheridan.akhtaraf.assignment2.data.PetDataService;
import sheridan.akhtaraf.assignment2.model.Pet;

import java.util.List;

@Controller
@RequestMapping("/pets")
public class PetListController {
    private final Logger log = LoggerFactory.getLogger(PetListController.class);

    private final PetDataService petDataService;

    public PetListController(PetDataService petDataService) {
        this.petDataService = petDataService;
    }

    @GetMapping
    ModelAndView petList() {
        log.trace("petList() is called.");
        List<Pet> list = petDataService.getAllPets();
        log.debug("List Size = " + list.size());
        return new ModelAndView("petTable", "pets", list);
    }
}

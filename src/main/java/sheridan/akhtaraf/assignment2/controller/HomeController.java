package sheridan.akhtaraf.assignment2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sheridan.akhtaraf.assignment2.data.PetDataService;
import sheridan.akhtaraf.assignment2.model.Pet;
import sheridan.akhtaraf.assignment2.model.PetGender;
import sheridan.akhtaraf.assignment2.model.PetType;

@Controller
public class HomeController {
    private final Logger log = LoggerFactory.getLogger(HomeController.class);
    private final PetDataService petDataService;

    public HomeController(PetDataService petDataService) {
        this.petDataService = petDataService;
    }


    @GetMapping(value = {"/", "/index"})
    String index() {
        log.trace("Index is called");
        return "index";
    }

}

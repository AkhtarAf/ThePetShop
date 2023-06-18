package sheridan.akhtaraf.assignment2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping(value = {"/", "/index"})
    String index() {
        log.trace("Index is called");
        return "index";
    }
}

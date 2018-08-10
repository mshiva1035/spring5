package group.springframework.chucknorrisforacutator.controller;

import group.springframework.chucknorrisforacutator.service.JokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/",""})
public class JokesController {

    @Autowired
    private JokesService jokesService;

    @GetMapping
    public String getJoke(Model model){

        model.addAttribute("joke", jokesService.getRandomQuote());
        return "chucknorris";
    }
}

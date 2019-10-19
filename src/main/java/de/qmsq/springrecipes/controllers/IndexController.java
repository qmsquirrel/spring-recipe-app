package de.qmsq.springrecipes.controllers;

import de.qmsq.springrecipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model theModel) {
        log.debug("In the Index controller");

        theModel.addAttribute("recipes",  recipeService.getRecipes());

        return "index";
    }

}

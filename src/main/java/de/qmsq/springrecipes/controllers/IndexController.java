package de.qmsq.springrecipes.controllers;

import de.qmsq.springrecipes.domain.Category;
import de.qmsq.springrecipes.domain.UnitOfMeasurement;
import de.qmsq.springrecipes.repositories.CategoryRepository;
import de.qmsq.springrecipes.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasurement> unitOfMeasurement = unitOfMeasureRepository.findByDescription("Tablespoon");

        System.out.println("Cat id is: "+ categoryOptional.get().getId());
        System.out.println("Unit id is: " + unitOfMeasurement.get().getId());

        return "index";
    }

}

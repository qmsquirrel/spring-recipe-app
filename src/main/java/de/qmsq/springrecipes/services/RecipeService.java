package de.qmsq.springrecipes.services;

import de.qmsq.springrecipes.commands.RecipeCommand;
import de.qmsq.springrecipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    RecipeCommand findCommandById(Long id);
    void deleteById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}

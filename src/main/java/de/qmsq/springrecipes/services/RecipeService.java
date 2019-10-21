package de.qmsq.springrecipes.services;

import de.qmsq.springrecipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long id);
}

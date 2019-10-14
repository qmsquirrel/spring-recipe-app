package de.qmsq.springrecipes.repositories;

import de.qmsq.springrecipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}

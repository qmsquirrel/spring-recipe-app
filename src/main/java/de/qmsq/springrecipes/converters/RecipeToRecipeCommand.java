package de.qmsq.springrecipes.converters;

import de.qmsq.springrecipes.commands.RecipeCommand;
import de.qmsq.springrecipes.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final NotesToNotesCommand notesToNotesCommand;
    private final CategoryToCategoryCommand categoryToCategoryCommand;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    public RecipeToRecipeCommand(NotesToNotesCommand notesToNotesCommand, CategoryToCategoryCommand categoryToCategoryCommand, IngredientToIngredientCommand ingredientToIngredientCommand) {
        this.notesToNotesCommand = notesToNotesCommand;
        this.categoryToCategoryCommand = categoryToCategoryCommand;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
    }


    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if (source == null) {
            return null;
        }

        final RecipeCommand rc = new RecipeCommand();
        rc.setId(source.getId());
        rc.setCookTime(source.getCookTime());
        rc.setPrepTime(source.getPrepTime());
        rc.setDescription(source.getDescription());
        rc.setDifficulty(source.getDifficulty());
        rc.setDirections(source.getDirections());
        rc.setServings(source.getServings());
        rc.setSource(source.getSource());
        rc.setUrl(source.getUrl());
        rc.setNotes(notesToNotesCommand.convert(source.getNotes()));
        rc.setImage(source.getImage());

        if (source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories()
                    .forEach( category ->
                            rc.getCategories().add(categoryToCategoryCommand.convert(category)));
        }

        if (source.getIngredients() != null && source.getIngredients().size() > 0) {
            source.getIngredients()
                    .forEach( ingredient ->
                            rc.getIngredients().add(ingredientToIngredientCommand.convert(ingredient)));
        }

        return rc;
    }
}

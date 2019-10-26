package de.qmsq.springrecipes.converters;

import de.qmsq.springrecipes.commands.IngredientCommand;
import de.qmsq.springrecipes.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasurementToUnitOfMeasurementCommand u2uc;

    public IngredientToIngredientCommand(UnitOfMeasurementToUnitOfMeasurementCommand u2uc) {
        this.u2uc = u2uc;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source == null) {
            return null;
        }

        final IngredientCommand ic = new IngredientCommand();
        ic.setId(source.getId());
        if (source.getRecipe() != null) {
            ic.setRecipeId(source.getRecipe().getId());
        }
        ic.setAmount(source.getAmount());
        ic.setDescription(source.getDescription());
        ic.setUnitOfMeasurement(u2uc.convert(source.getUnitOfMeasurement()));

        return ic;
    }
}

package de.qmsq.springrecipes.converters;

import de.qmsq.springrecipes.commands.IngredientCommand;
import de.qmsq.springrecipes.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasurementCommandToUnitOfMeasurement uc2u;

    public IngredientCommandToIngredient(UnitOfMeasurementCommandToUnitOfMeasurement uc2u) {
        this.uc2u = uc2u;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUnitOfMeasurement(uc2u.convert(source.getUnitOfMeasurement()));

        return ingredient;
    }
}

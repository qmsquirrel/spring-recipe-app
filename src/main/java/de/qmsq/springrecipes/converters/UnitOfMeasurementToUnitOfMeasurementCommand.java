package de.qmsq.springrecipes.converters;

import de.qmsq.springrecipes.commands.UnitOfMeasurementCommand;
import de.qmsq.springrecipes.domain.UnitOfMeasurement;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasurementToUnitOfMeasurementCommand implements Converter<UnitOfMeasurement, UnitOfMeasurementCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasurementCommand convert(UnitOfMeasurement source) {
        if (source == null) {
            return null;
        }

        final UnitOfMeasurementCommand uomc = new UnitOfMeasurementCommand();
        uomc.setId(source.getId());
        uomc.setDescription(source.getDescription());

        return uomc;
    }
}

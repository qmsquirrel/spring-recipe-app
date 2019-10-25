package de.qmsq.springrecipes.converters;

import de.qmsq.springrecipes.commands.UnitOfMeasurementCommand;
import de.qmsq.springrecipes.domain.UnitOfMeasurement;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasurementCommandToUnitOfMeasurement implements Converter<UnitOfMeasurementCommand, UnitOfMeasurement> {


    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasurement convert(UnitOfMeasurementCommand source) {
        if (source == null) {
            return null;
        }

        final UnitOfMeasurement uom = new UnitOfMeasurement();
        uom.setId(source.getId());
        uom.setDescription(source.getDescription());
        return uom;
    }
}

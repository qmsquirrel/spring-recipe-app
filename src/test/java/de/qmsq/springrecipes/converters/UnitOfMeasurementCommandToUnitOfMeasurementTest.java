package de.qmsq.springrecipes.converters;

import de.qmsq.springrecipes.commands.UnitOfMeasurementCommand;
import de.qmsq.springrecipes.domain.UnitOfMeasurement;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasurementCommandToUnitOfMeasurementTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);

    UnitOfMeasurementCommandToUnitOfMeasurement converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasurementCommandToUnitOfMeasurement();

    }

    @Test
    public void testNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasurementCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UnitOfMeasurementCommand command = new UnitOfMeasurementCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasurement uom = converter.convert(command);

        //then
        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());

    }

}
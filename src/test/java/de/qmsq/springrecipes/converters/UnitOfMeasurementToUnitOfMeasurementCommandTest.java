package de.qmsq.springrecipes.converters;

import de.qmsq.springrecipes.commands.UnitOfMeasurementCommand;
import de.qmsq.springrecipes.domain.UnitOfMeasurement;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasurementToUnitOfMeasurementCommandTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);

    UnitOfMeasurementToUnitOfMeasurementCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasurementToUnitOfMeasurementCommand();
    }

    @Test
    public void testNullObjectConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasurement()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UnitOfMeasurement uom = new UnitOfMeasurement();
        uom.setId(LONG_VALUE);
        uom.setDescription(DESCRIPTION);
        //when
        UnitOfMeasurementCommand uomc = converter.convert(uom);

        //then
        assertEquals(LONG_VALUE, uomc.getId());
        assertEquals(DESCRIPTION, uomc.getDescription());
    }


}
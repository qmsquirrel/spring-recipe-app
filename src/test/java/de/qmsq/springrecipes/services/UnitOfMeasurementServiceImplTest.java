package de.qmsq.springrecipes.services;

import de.qmsq.springrecipes.commands.UnitOfMeasurementCommand;
import de.qmsq.springrecipes.converters.UnitOfMeasurementToUnitOfMeasurementCommand;
import de.qmsq.springrecipes.domain.UnitOfMeasurement;
import de.qmsq.springrecipes.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UnitOfMeasurementServiceImplTest {

    UnitOfMeasurementToUnitOfMeasurementCommand unitOfMeasurementToUnitOfMeasurementCommand;
    UnitOfMeasurementService service;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        unitOfMeasurementToUnitOfMeasurementCommand = new UnitOfMeasurementToUnitOfMeasurementCommand();
        service = new UnitOfMeasurementServiceImpl(unitOfMeasureRepository, unitOfMeasurementToUnitOfMeasurementCommand);
    }

    @Test
    public void listAllUoms() throws Exception {
        //given
        Set<UnitOfMeasurement> unitOfMeasurements = new HashSet<>();
        UnitOfMeasurement uom1 = new UnitOfMeasurement();
        uom1.setId(1L);
        unitOfMeasurements.add(uom1);

        UnitOfMeasurement uom2 = new UnitOfMeasurement();
        uom2.setId(2L);
        unitOfMeasurements.add(uom2);

        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasurements);

        //when
        Set<UnitOfMeasurementCommand> commands = service.listAllUoms();

        //then
        assertEquals(2, commands.size());
        verify(unitOfMeasureRepository, times(1)).findAll();
    }
}
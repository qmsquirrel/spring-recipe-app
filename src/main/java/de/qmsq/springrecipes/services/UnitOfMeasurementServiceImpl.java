package de.qmsq.springrecipes.services;

import de.qmsq.springrecipes.commands.UnitOfMeasurementCommand;
import de.qmsq.springrecipes.converters.UnitOfMeasurementToUnitOfMeasurementCommand;
import de.qmsq.springrecipes.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasurementServiceImpl implements  UnitOfMeasurementService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasurementToUnitOfMeasurementCommand unitOfMeasurementToUnitOfMeasurementCommand;

    public UnitOfMeasurementServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasurementToUnitOfMeasurementCommand unitOfMeasurementToUnitOfMeasurementCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasurementToUnitOfMeasurementCommand = unitOfMeasurementToUnitOfMeasurementCommand;
    }

    @Override
    public Set<UnitOfMeasurementCommand> listAllUoms() {

        return StreamSupport.stream(unitOfMeasureRepository.findAll()
                .spliterator(), false)
                .map(unitOfMeasurementToUnitOfMeasurementCommand::convert)
                .collect(Collectors.toSet());
    }
}

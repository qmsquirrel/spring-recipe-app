package de.qmsq.springrecipes.services;

import de.qmsq.springrecipes.commands.UnitOfMeasurementCommand;

import java.util.Set;

public interface UnitOfMeasurementService {

    Set<UnitOfMeasurementCommand> listAllUoms();
}

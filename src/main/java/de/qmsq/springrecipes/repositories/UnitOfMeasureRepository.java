package de.qmsq.springrecipes.repositories;

import de.qmsq.springrecipes.domain.UnitOfMeasurement;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasurement, Long> {
}

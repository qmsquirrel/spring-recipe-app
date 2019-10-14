package de.qmsq.springrecipes.repositories;

import de.qmsq.springrecipes.domain.UnitOfMeasurement;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasurement, Long> {

    Optional<UnitOfMeasurement> findByDescription(String description);
}

package de.qmsq.springrecipes.repositories;

import de.qmsq.springrecipes.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}

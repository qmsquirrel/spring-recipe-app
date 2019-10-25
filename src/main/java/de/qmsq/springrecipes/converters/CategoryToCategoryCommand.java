package de.qmsq.springrecipes.converters;

import de.qmsq.springrecipes.commands.CategoryCommand;
import de.qmsq.springrecipes.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category source) {
        if (source == null) {
            return null;
        }

        final CategoryCommand cc = new CategoryCommand();
        cc.setId(source.getId());
        cc.setDescription(source.getDescription());

        return cc;
    }
}

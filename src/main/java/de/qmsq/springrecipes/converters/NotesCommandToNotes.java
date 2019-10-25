package de.qmsq.springrecipes.converters;

import de.qmsq.springrecipes.commands.NotesCommand;
import de.qmsq.springrecipes.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        if (source == null) {
            return null;
        }

        final Notes nc = new Notes();
        nc.setId(source.getId());
        nc.setRecipeNotes(source.getRecipeNotes());

        return nc;
    }
}

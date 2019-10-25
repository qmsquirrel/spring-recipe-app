package de.qmsq.springrecipes.converters;

import de.qmsq.springrecipes.commands.NotesCommand;
import de.qmsq.springrecipes.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes source) {
        if (source == null) {
            return null;
        }

        final NotesCommand nc = new NotesCommand();
        nc.setId(source.getId());
        nc.setRecipeNotes(source.getRecipeNotes());

        return nc;
    }
}

package de.qmsq.springrecipes.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UnitOfMeasurementCommand {
    private Long id;
    private String description;
}

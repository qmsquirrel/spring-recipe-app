package de.qmsq.springrecipes.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasurement unitOfMeasurement;

    @ManyToOne
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasurement unitOfMeasurement) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasurement unitOfMeasurement, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasurement = unitOfMeasurement;
        this.recipe = recipe;
    }

}

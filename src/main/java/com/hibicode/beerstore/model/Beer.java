package com.hibicode.beerstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Beer {

    @Id
    @EqualsAndHashCode.Include
    @SequenceGenerator(name = "beer_seq", sequenceName = "beer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beer_seq")
    private Long id;
    @NotBlank(message = "beers-1")
    private String name;
    @NotNull(message = "beers-2")
    private BeerType type;
    @NotNull(message = "beers-3")
    @DecimalMin(value = "0", message = "beers-4")
    private BigDecimal volume;

    @Transient
    @JsonIgnore
    public boolean isNew() {
        return this.id == null;
    }

    @Transient
    @JsonIgnore
    public boolean alreadyExist() {
        return this.id != null;
    }
}

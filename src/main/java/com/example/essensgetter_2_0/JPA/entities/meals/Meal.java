package com.example.essensgetter_2_0.JPA.entities.meals;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@MappedSuperclass
public abstract class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    @Column(name = "id", nullable = false)
    protected Long id;
    protected String name;
    private String components;
    private String allergens;
    private String price;
    private String category;
    private LocalDate servingDate;
    @EqualsAndHashCode.Exclude
    private Double rating = 0.0;
    @EqualsAndHashCode.Exclude
    private Integer votes = 0;
    @EqualsAndHashCode.Exclude
    private Integer starsTotal = 0;

    public Meal() {
    }

    public Meal(String name, String components, String price, String category, LocalDate servingDate, String allergens) {
        this.name = name;
        this.components = components;
        this.allergens = allergens;
        this.price = price;
        this.category = category;
        this.servingDate = servingDate;
        this.rating = 0.0;
        this.votes = 0;
        this.starsTotal = 0;
    }

    @Override
    public String toString() {
        return "Meal: " + "name=" + name + ", description=" + components + ", allergens=" + allergens + ", price=" +
                price + ", category=" + category + ", servingDate=" + servingDate + ", rating=" + rating +
                ", votes=" + votes + ", starsTotal=" + starsTotal + ", votes=" + votes;
    }
}

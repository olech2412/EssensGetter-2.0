package com.example.essensgetter_2_0.JPA.entities.meals;

import com.example.essensgetter_2_0.JPA.entities.mensen.Mensa_Academica;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "meals_mensa_academica")
public class Meals_Mensa_Academica extends Meal {

    @ManyToOne
    @JoinColumn(name = "mensa_academica_id", nullable = false)
    private Mensa_Academica mensa_academica;

    public Meals_Mensa_Academica() {

    }

}
package com.example.essensgetter_2_0.JPA.entities.mensen;

import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Mensa_Academica;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "mensa_academica")
public class Mensa_Academica extends Mensa {

    @OneToMany(mappedBy = "mensa_academica")
    private Set<Meals_Mensa_Academica> meals_mensa_academica;


}
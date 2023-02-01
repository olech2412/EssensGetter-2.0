package com.example.essensgetter_2_0.JPA.mensen;

import com.example.essensgetter_2_0.JPA.meals.Meals_Mensa_Academica;
import com.example.essensgetter_2_0.JPA.meals.Meals_Schoenauer_Str;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mensa_academica")
public class Mensa_Academica extends Mensa {

    @OneToMany(mappedBy = "mensa_academica")
    private Set<Meals_Mensa_Academica> meals_mensa_academica;


}
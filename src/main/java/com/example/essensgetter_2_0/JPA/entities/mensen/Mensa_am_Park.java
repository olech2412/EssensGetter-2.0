package com.example.essensgetter_2_0.JPA.entities.mensen;

import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Mensa_am_Park;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mensa_am_park")
public class Mensa_am_Park extends Mensa {

    @OneToMany(mappedBy = "mensa_am_park")
    private Set<Meals_Mensa_am_Park> meals_mensa_am_park;


}

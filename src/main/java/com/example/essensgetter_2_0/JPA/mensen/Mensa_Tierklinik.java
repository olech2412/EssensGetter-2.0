package com.example.essensgetter_2_0.JPA.mensen;

import com.example.essensgetter_2_0.JPA.meals.Meals_Mensa_Tierklinik;
import com.example.essensgetter_2_0.JPA.meals.Meals_Schoenauer_Str;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mensa_tierklinik")
public class Mensa_Tierklinik extends Mensa {

    @OneToMany(mappedBy = "mensa_tierklinik")
    private Set<Meals_Mensa_Tierklinik> meals_mensa_tierklinik;


}
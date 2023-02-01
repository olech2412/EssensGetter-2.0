package com.example.essensgetter_2_0.JPA.mensen;

import com.example.essensgetter_2_0.JPA.meals.Meals_Mensa_Peterssteinweg;
import com.example.essensgetter_2_0.JPA.meals.Meals_Schoenauer_Str;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mensa_peterssteinweg")
public class Mensa_Peterssteinweg extends Mensa {

    @OneToMany(mappedBy = "mensa_peterssteinweg")
    private Set<Meals_Mensa_Peterssteinweg> meals_mensa_peterssteinweg;


}
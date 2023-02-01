package com.example.essensgetter_2_0.JPA.mensen;

import com.example.essensgetter_2_0.JPA.meals.Meals_Mensa_am_Medizincampus;
import com.example.essensgetter_2_0.JPA.meals.Meals_Schoenauer_Str;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mensa_am_medizincampus")
public class Mensa_am_Medizincampus extends Mensa {

    @OneToMany(mappedBy = "mensa_am_medizincampus")
    private Set<Meals_Mensa_am_Medizincampus> meals_mensa_am_medizincampus;


}
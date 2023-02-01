package com.example.essensgetter_2_0.JPA.mensen;

import com.example.essensgetter_2_0.JPA.meals.Meals_Cafeteria_Dittrichring;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cafeteria_dittrichring")
public class Cafeteria_Dittrichring extends Mensa {

    @OneToMany(mappedBy = "cafeteria_dittrichring")
    private Set<Meals_Cafeteria_Dittrichring> meals_cafeteria_dittrichrings;


}
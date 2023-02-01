package com.example.essensgetter_2_0.JPA.entities.meals;

import com.example.essensgetter_2_0.JPA.entities.mensen.Mensa_am_Park;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "meals_mensa_am_park")
public class Meals_Mensa_am_Park extends Meal {

    @ManyToOne
    @JoinColumn(name = "mensa_am_park_id", nullable = false)
    private Mensa_am_Park mensa_am_park;

    public Meals_Mensa_am_Park(){

    }

}

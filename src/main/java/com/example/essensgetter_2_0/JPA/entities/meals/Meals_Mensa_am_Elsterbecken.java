package com.example.essensgetter_2_0.JPA.entities.meals;

import com.example.essensgetter_2_0.JPA.entities.mensen.Mensa_am_Elsterbecken;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "meals_mensa_am_elsterbecken")
public class Meals_Mensa_am_Elsterbecken extends Meal {

    @ManyToOne
    @JoinColumn(name = "mensa_am_elsterbecken_id", nullable = false)
    private Mensa_am_Elsterbecken mensa_am_elsterbecken;

    public Meals_Mensa_am_Elsterbecken(){

    }

}

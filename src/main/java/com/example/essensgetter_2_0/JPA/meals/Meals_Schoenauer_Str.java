package com.example.essensgetter_2_0.JPA.meals;

import com.example.essensgetter_2_0.JPA.mensen.Mensa_Schoenauer_Str;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "meals_schoenauer_str")
public class Meals_Schoenauer_Str extends Meal {

    @ManyToOne
    @JoinColumn(name = "mensa_schoenauer_str_id", nullable = false)
    private Mensa_Schoenauer_Str mensa_schoenauer_str;

    public Meals_Schoenauer_Str(){

    }

}

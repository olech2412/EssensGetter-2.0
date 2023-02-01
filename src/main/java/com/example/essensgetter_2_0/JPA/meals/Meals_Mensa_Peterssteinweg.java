package com.example.essensgetter_2_0.JPA.meals;

import com.example.essensgetter_2_0.JPA.mensen.Cafeteria_Dittrichring;
import com.example.essensgetter_2_0.JPA.mensen.Mensa_Peterssteinweg;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "meals_mensa_peterssteinweg")
public class Meals_Mensa_Peterssteinweg extends Meal {

    @ManyToOne
    @JoinColumn(name = "mensa_peterssteinweg_id", nullable = false)
    private Mensa_Peterssteinweg mensa_peterssteinweg;

    public Meals_Mensa_Peterssteinweg() {

    }

}
